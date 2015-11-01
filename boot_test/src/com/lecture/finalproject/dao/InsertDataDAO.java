package com.lecture.finalproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.lecture.finalproject.model.ModelComment;

public class InsertDataDAO {
	Connection con;

	public void save(ModelComment declira) throws SQLException {
		con = JDBCMannager.getInstance();
		String insert = "insert into comment_tb (comment_no, commentPost_date, content, user_id, image_url, travelPost_no) VALUES (?, now(), ?, ?, ?,?)";
		PreparedStatement ps = con.prepareStatement(insert);
		ps.setInt(1, declira.getComment_no());
		ps.setString(2, declira.getCommentPost_date());
		ps.setString(3, declira.getContent());
		ps.setString(4, declira.getUser_id());
		ps.setString(5, declira.getImage_url());
		ps.setInt(6, declira.getTravelPost_no());
		ps.executeUpdate();
		ps.close();
		con.commit();
		System.out.println("Storing Student Object is Done!");
	}

	public void update(ModelComment std) {
		System.out.println("Storing Student Object is Done!");
	}

	public void remove(ModelComment std) {
		System.out.println("Storing Student Object is Done!");
	}

	public List<ModelComment> findAll() {
		System.out.println("Storing Student Object is Done!");
		return null;
	}

}
