package com.lecture.finalproject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lecture.finalproject.dao.DaoTravlePlace;
import com.lecture.finalproject.model.ModelFrontTravlePost;
import com.lecture.finalproject.service.ServiceTwitterParser;

import twitter4j.Twitter;
import twitter4j.User;

/**
 * Servlet implementation class MypageController
 */

@WebServlet("/my")
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

	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		HttpSession session = request.getSession();
		User user = null;
		boolean isLogin = session.getAttribute("checkLogin") == null ? false : true;
		DaoTravlePlace db = new DaoTravlePlace();	
		List<ModelFrontTravlePost> posts = null; 
		
		if(isLogin)
		{
			user = (User)session.getAttribute("twitterUser");
			posts = db.getFrontTravlePostListById(Long.toString(user.getId()));
						
			request.setAttribute("userImage", user.getProfileImageURL());
			request.setAttribute("userName", user.getName());
			request.setAttribute("posts",posts);		
		}
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/myPage.jsp");
        dispatcher.forward(request, response);
    }
	
	
	

}
