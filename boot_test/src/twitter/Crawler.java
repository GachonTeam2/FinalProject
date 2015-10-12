package twitter;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import twitter4j.HashtagEntity;
import twitter4j.IDs;
import twitter4j.MediaEntity;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class Crawler {

	public String consumer;
	public String consumerSecret;
	public String accessToken;
	public String accessTokenSecret;
	public Twitter twi;
	public Connection con;
	private PreparedStatement pstmt;

	public Crawler(String consumer, String consumerSecret, String accessToken, String accessTokenSecret) {
		this.consumer = consumer;
		this.consumerSecret = consumerSecret;
		this.accessToken = accessToken;
		this.accessTokenSecret = accessTokenSecret;
		init();
		getFavoriteStatus();
		userInfo();
		getFriendList();
	}

	public void init() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(consumer).setOAuthConsumerSecret(consumerSecret)
				.setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(accessTokenSecret);
		TwitterFactory tf = new TwitterFactory(cb.build());
		twi = tf.getInstance();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost/socialdata?autoReconnect=true&useUnicode=true&characterEncoding=utf8",
					"root", "apmsetup");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void userInfo() {
		String sql = "INSERT INTO twitter_user values(?,?,?,?,?,?,?)";

		try {
			User user = twi.verifyCredentials();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, String.valueOf(user.getId()));
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getScreenName());
			pstmt.setString(4, user.getProfileImageURL());
			pstmt.setInt(5, user.getFollowersCount());
			pstmt.setInt(6, user.getFriendsCount());
			pstmt.setInt(7, user.getStatusesCount());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getFriendList() {
		try {

			String sql = "INSERT INTO twitter_friend_list values(?,?,?,?,?)";
			ResponseList<User> s = null;
			IDs ids;

			long cursor = -1;
			int num = 0;

			do {

				User user = twi.verifyCredentials();
				ids = twi.getFriendsIDs(cursor);
				num++;
				for (long id : ids.getIDs()) {
					for (int i = 0; i < num; i++) {
						try {

							pstmt = con.prepareStatement(sql);
							// lookupUsers�� ���� Ư�� ����� �˻�
							s = twi.lookupUsers(id);

							pstmt.setString(1, String.valueOf(s.get(i).getId()));
							pstmt.setString(2, String.valueOf(user.getId()));
							pstmt.setString(3, s.get(i).getName());
							pstmt.setString(4, s.get(i).getScreenName());
							pstmt.setString(5, s.get(i).getProfileImageURL());
							pstmt.executeUpdate();
							// ���� ģ���� Ÿ�Ӷ��� �������� Parameter : User's ID
							getFriendTimeline(s.get(i).getId());
							pstmt.clearParameters();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} while ((cursor = ids.getNextCursor()) != 0);

		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get friends' ids: " + te.getMessage());
			System.exit(-1);
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void getFriendTimeline(long id) {
		List<User> users = null;
		HashtagEntity[] hashtags;
		MediaEntity[] medias;

		String Link = null;
		String Image = null;
		String Type = null;
		String Hash = null;

		try {
			users = twi.lookupUsers(id);
			for (int pageCheck = 1; pageCheck < 4; pageCheck++) {
				Paging page = new Paging(pageCheck, 100);
				List<Status> statuses = twi.getUserTimeline(users.get(0).getScreenName(), page);
				for (int i = 0; i < statuses.size(); i++) {
					medias = statuses.get(i).getMediaEntities();
					hashtags = statuses.get(i).getHashtagEntities();

					for (HashtagEntity hash : hashtags) {
						Hash = hash.getText();
					}
					for (MediaEntity media : medias) {

						if (media.getURL() != null)
							Link = media.getURL();
						else
							Link = media.getDisplayURL();
						Image = media.getMediaURL();
						Type = media.getType();
					}

					String sql = "INSERT INTO twitter_data values(?,?,?,?,?,?,?,?,?,?,?,?)";

					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, String.valueOf(statuses.get(i).getId()));
					pstmt.setString(2, String.valueOf(users.get(0).getId()));
					pstmt.setString(3, String.valueOf(statuses.get(i).getCreatedAt()));
					pstmt.setString(4, Image);
					pstmt.setString(5, statuses.get(i).getText());
					pstmt.setString(6, Link);
					pstmt.setString(7, Type);
					pstmt.setString(8, Hash);
					pstmt.setInt(9, statuses.get(i).getRetweetCount());
					pstmt.setInt(10, statuses.get(i).getFavoriteCount());
					if (statuses.get(i).getGeoLocation() != null) {
						pstmt.setString(11, String.valueOf(statuses.get(i).getGeoLocation().getLatitude()));
						pstmt.setString(12, String.valueOf(statuses.get(i).getGeoLocation().getLongitude()));
					} else {
						pstmt.setString(11, null);
						pstmt.setString(12, null);
					}

					pstmt.executeUpdate();
					getReplyInStatus(statuses.get(i));
					pstmt.clearParameters();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TwitterException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void getFavoriteStatus() {
		try {
			List<Status> statuses;
			String sql = "INSERT INTO twitter_like values(?,?,?)";
			statuses = twi.getFavorites();
			pstmt = con.prepareStatement(sql);
			for (Status status : statuses) {
				pstmt.setString(1, String.valueOf(status.getId()));
				pstmt.setString(2, String.valueOf(status.getUser().getId()));
				pstmt.setString(3, status.getUser().getScreenName());
				pstmt.executeUpdate();
				pstmt.clearParameters();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get favorites: " + te.getMessage());
		}

	}

	private void getReplyInStatus(Status statuses) {

		String sql = "INSERT INTO twitter_comment values(?,?,?)";

		try {
			if (statuses.getId() != -1 && statuses.getInReplyToScreenName() != null) {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, String.valueOf(statuses.getId()));
				pstmt.setString(2, String.valueOf(statuses.getInReplyToUserId()));
				pstmt.setString(3, statuses.getInReplyToScreenName());
				pstmt.executeUpdate();
				pstmt.clearParameters();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	}
