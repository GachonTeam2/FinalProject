package com.lecture.finalproject.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lecture.finalproject.dao.InsertDataDAO;
import com.lecture.finalproject.dao.JDBCMannager;
import com.lecture.finalproject.service.ServiceGetDetailInfo;

/**
 * Servlet implementation class GetDetailInfo_action
 */
@WebServlet("/detail")
public class Detail_action extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	InsertDataDAO InsertDataDao = new InsertDataDAO();
	
	Connection con;
	Statement stmt;
	ResultSet res;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Detail_action() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String postNum = request.getParameter("travlePostNumber");
		ServiceGetDetailInfo collector = new ServiceGetDetailInfo();

		request.setAttribute("hashList", collector.getHashList(Integer.parseInt(postNum)));
		request.setAttribute("featureList", collector.getFeatureList(Integer.parseInt(postNum)));
		request.setAttribute("informationList", collector.getInformationList(Integer.parseInt(postNum)));
		request.setAttribute("imageList", collector.getImageList(Integer.parseInt(postNum)));
		request.setAttribute("location", collector.getLocation(Integer.parseInt(postNum)));
		request.setAttribute("commentList", collector.getCommentList(Integer.parseInt(postNum)));
		request.setAttribute("travlePost", collector.getTravlePost(Integer.parseInt(postNum)));
		request.setAttribute("writer", collector.getWriter(Integer.parseInt(postNum)));
		
		//Vector<ModelComment> vlist = new Vector<ModelComment>();
		try {
			con = JDBCMannager.getInstance();
			stmt=con.createStatement();
			int comment_no = Integer.parseInt(request.getParameter("0"));
			String commentPost_date = request.getParameter("0");
			String commentId = request.getParameter("commentId");
			String commentContent = request.getParameter("commentInput");
			String commentImage = request.getParameter("commentImage");
			int pNum = Integer.parseInt(postNum);

			String query = "insert into comment_tb(comment_no, commentPost_date, content, user_id, image_url, travelPost_no) values(0,now(),"+commentId+","+commentContent+","+commentImage+","+pNum+")";
			stmt.executeQuery(query);
			
		} catch (SQLException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/detailPage.jsp");
			dispatcher.forward(request, response);
			System.out.println(e.getMessage());
		}
		
		
	}
}
