package com.lecture.finalproject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class RegisterMgr {
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String JDBC_URL = "jdbc:mysql://localhost/tourapi?characterEncoding=UTF-8&characterSetResults=UTF-8";
	final String USER = "root";
	final String PASS="apmsetup";
	
	public RegisterMgr(){
		try{
			Class.forName(JDBC_DRIVER);
		}catch(Exception e){
			System.out.println("Error : JDBC 드라이버 로딩 실해");
		}
	}//RegisterMgr()
	
	public Vector getMemberList(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Vector vecList = new Vector();
		try{
			conn = DriverManager.getConnection(JDBC_URL,USER,PASS);
			String strQuery = "select * from tour_information";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(strQuery);
			while(rs.next()){
				RegisterBean regBean = new RegisterBean();
				regBean.setAddr1(rs.getString("addr1"));
				regBean.setAddr2(rs.getString("addr2"));
				regBean.setAreacode(rs.getInt("areacode"));
				regBean.setCat1(rs.getString("cat1"));
				regBean.setCat2(rs.getString("cat2"));
				regBean.setCat3(rs.getString("cat3"));
				regBean.setContentid(rs.getInt("contentid"));
				regBean.setContenttypeid(rs.getInt("contenttypeid"));
				regBean.setCreatedtime(rs.getString("createdtime"));
				regBean.setFirstimage(rs.getString("firstimage"));
				regBean.setSecondimage(rs.getString("secondimage"));
				regBean.setMapx(rs.getString("mapx"));
				regBean.setMapy(rs.getString("mapy"));
				regBean.setMlevel(rs.getInt("mlevel"));
				regBean.setModifiedtime(rs.getString("modifiedtime"));
				regBean.setReadcount(rs.getInt("readcoount"));
				regBean.setSigungucode(rs.getInt("sigungucode"));
				regBean.setTel(rs.getString("tel"));
				regBean.setTitle(rs.getString("title"));
				regBean.setZipcode(rs.getString("zipcode"));
				vecList.add(regBean);
			}
		}catch(Exception ex){
			System.out.println("Exeption"+ex);
		}finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException e){}
			}
			if(stmt != null){
				try{
					stmt.close();
				}catch(SQLException e){}
			}
			if(stmt != null){
				try{
					conn.close();
				}catch(SQLException e){}
			}
		}
		return vecList;
	}
}
