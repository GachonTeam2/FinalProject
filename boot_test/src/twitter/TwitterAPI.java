package twitter;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterAPI {
	private String consumer_key;
	private String consumer_secret;
	public RequestToken requestToken;
	public AccessToken accessToken;
	public Twitter twitter = null;

	Crawler twitterCrawler;

	public TwitterAPI() {
		twitter = new TwitterFactory().getInstance();
	}

	public void setConsumer_key(String consumer_key) {
		this.consumer_key = consumer_key;
	}

	public void setConsumer_secret(String consumer_secret) {
		this.consumer_secret = consumer_secret;
	}

	public void setRequestToken(RequestToken request) {
		this.requestToken = request;
	}

	// ���� ��û ��ū ��
	public void getRequestToken() throws Exception {
		twitter.setOAuthConsumer(this.consumer_key, this.consumer_secret);
		requestToken = twitter.getOAuthRequestToken();
		System.out.println(requestToken);
	}

	// ������ ��ū ��
	public void getAccessToken(String requestToken, String requestTokensecret, String oauth_verifier) throws Exception {
		try {
			twitter.setOAuthConsumer(this.consumer_key, this.consumer_secret);
			accessToken = twitter.getOAuthAccessToken(new RequestToken(requestToken, requestTokensecret),
					oauth_verifier);
		} catch (TwitterException te) {
			System.out.println("Oauthorization Error" + te);
		}
		twitterCrawler = new Crawler(consumer_key, consumer_secret, accessToken.getToken(),
				accessToken.getTokenSecret());
	}

}
