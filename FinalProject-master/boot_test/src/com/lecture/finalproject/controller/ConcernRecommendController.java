package com.lecture.finalproject.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lecture.finalproject.dao.DaoTravlePlace;
import com.lecture.finalproject.model.ModelFrontTravlePost;

/**
 * Servlet implementation class MainController
 */

@WebServlet("/concern")
public class ConcernRecommendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConcernRecommendController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8"); 
		
		String checkHash;
		DaoTravlePlace db = new DaoTravlePlace();
		List<ModelFrontTravlePost> posts = null;
		
		String searchWord = new String(request.getParameter("searchWord") .getBytes("8859_1"), "UTF-8"); 
		checkHash = searchWord.substring(0, 1);
		
		
		
		//hash Tag 검색인경우
		if(checkHash.equals("#"))
		{
			searchWord = searchWord.substring(1);
			posts = db.getFrontTravlePostByHashTag(searchWord);
			
		}//Hash tag검색이 아닌경우
		else
			 posts = db.getFrontTravlePostBySearchWord(searchWord);		
		
		
		request.setAttribute("posts", posts);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/concernRecommendPage.jsp");
   	    dispatcher.forward(request, response);
	}
    
 
 
}
