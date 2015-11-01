package com.lecture.finalproject.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lecture.finalproject.dao.JDBCMannager;
import com.lecture.finalproject.model.ModelComment;
import com.lecture.finalproject.service.ServiceGetDetailInfo;
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class GetDetailInfo_action
 */
@WebServlet("/detail")
public class Detail_action extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	ModelComment mc = new ModelComment();
	Connection connection = JDBCMannager.getInstance();
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
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
		
		//Vector<ModelComment> vlist = new Vector<ModelComment>();
		try {
			String sql = "insert into comment_tb(comment_no, commentPost_date, content, user_id, image_url, travelPost_no) values(?,now(),?,?,?,?)";
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, mc.getComment_no());
			pstmt.setString(2, mc.getCommentPost_date());
			pstmt.setString(3, mc.getContent());
			pstmt.setString(4, mc.getUser_id());
			pstmt.setString(5, mc.getImage_url());
			pstmt.setInt(6, mc.getTravelPost_no());
			
			pstmt.executeUpdate();
			
			rs.close();
			pstmt.close();
			connection.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
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
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/detailPage.jsp");
		dispatcher.forward(request, response);
	}
}
