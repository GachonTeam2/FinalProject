package login.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lecture.finalproject.service.ServiceTwitterParser;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Servlet implementation class MainController
 */


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final String CONSUMER_KEY = "GEz4eKsuI0sm86utoDsEOsBak"; //APP등록후받은consumer key
	final String CONSUMER_SECRET = "AjM852KsT3lvBwJ84AJfiZLQslty0QN3NxrHeo7PQOZ721oKUd"; //APP등록후받은consumer secret
	
       
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
	    processRequest(request,response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		HttpSession session = request.getSession();
		User user = null;
		boolean isLogin = session.getAttribute("checkLogin") == null ? false : true;
		
		if(isLogin)
		{
			Twitter twitter = (Twitter) request.getSession().getAttribute("twitter");
			 
			try {
				 user = twitter.verifyCredentials();
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("isLogin", "1");
			request.setAttribute("name", user.getName());
			request.setAttribute("imageUrl", user.getProfileImageURL());	
			
			session.setAttribute("twitterUser", user);
			
			ServiceTwitterParser one = new ServiceTwitterParser();
			
			ArrayList<User> friends = one.getFriendsList(twitter);
			ArrayList<User> followers = one.getFriendsList(twitter);
			
			for(int i=0;i<friends.size(); i++)
			{
				System.out.println(friends.get(i).getName());
			}
			
			for(int i=0;i<followers.size(); i++)
			{
				System.out.println(followers.get(i).getName());
			}
			
		}
		
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/loginPage.jsp");
	    dispatcher.forward(request, response);
	    
	    

	}
   
}
