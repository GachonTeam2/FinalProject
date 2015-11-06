package REST;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lecture.finalproject.model.ModelUser;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import twitter4j.PagableResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

/**
 * Servlet implementation class RestGetPeople
 */
@WebServlet("/RestGetPeople")
public class RestGetPeople extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestGetPeople() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Twitter twitter = (Twitter)session.getAttribute("twitter");
		
		String method = request.getParameter("method");
		List<ModelUser> listFriends = new ArrayList<ModelUser>();
	
		if(method.equalsIgnoreCase("getFrindAndFollowerList")){
			getFriendAndFollowerList(twitter,listFriends);
		}
		
		JSONArray FrinedJsonArray = JSONArray.fromObject(listFriends);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("friendList", FrinedJsonArray);
		
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject);
		PrintWriter out = response.getWriter();
		
		out.println(jsonObject);	
	}
	
	private void getFriendAndFollowerList(Twitter twitter, List<ModelUser> listFriends){
		
		   try {
	            long cursor = -1;
	            PagableResponseList<User> pagableFollowings;
	            do {
	                pagableFollowings = twitter.getFriendsList(twitter.getId(), cursor);
	                for (User user : pagableFollowings) {
	                	ModelUser friend = new ModelUser(Long.toString(user.getId()), user.getName(), user.getProfileImageURL(),false);
	           
	                    listFriends.add(friend); // ArrayList<User>
	                }
	            } while ((cursor = pagableFollowings.getNextCursor()) != 0);

	        } catch (TwitterException e) {
	        	System.out.println(e.getMessage());
	        }
	}

	
}
