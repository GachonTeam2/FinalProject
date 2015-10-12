package mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lecture.finalproject.service.ServiceTwitterParser;

import twitter4j.Twitter;
import twitter4j.User;

/**
 * Servlet implementation class MypageController
 */

public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageController() {
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
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		HttpSession session = request.getSession();
		Twitter twitter = (Twitter) session.getAttribute("twitter");
		
		ServiceTwitterParser one = new ServiceTwitterParser();
		
		List<User> friendsList = one.getFriendsList(twitter);
		List<User> followerList = one.getFriendsList(twitter);
		
		for(int i=0;i<friendsList.size(); i++)
		{
			System.out.println(friendsList.get(i));
		}
		
		System.out.println("");
		
		for(int i=0;i<followerList.size(); i++)
		{
			System.out.println(followerList.get(i));
		}
		

		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/myPage.jsp");
        dispatcher.forward(request, response);
    }
	
	
	

}
