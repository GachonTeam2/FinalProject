package com.lecture.finalproject.dao;


import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lecture.finalproject.model.ModelTravelPost;


public class Travelpost_db {
    private static Logger logger = LoggerFactory.getLogger(Travelpost_db.class);
    ModelTravelPost tp = new ModelTravelPost();
    
    private Connection con;
    private Statement stmt;
    private String driver ="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/finalproject";
    private String id = "root";
    private String passwd="1313";
    
    public void Database() 
    {
        try {
            Class.forName(driver);
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject","root","1313");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("Database", e.getStackTrace());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("Database", e.getStackTrace());
        }
        
    }
    
    public Connection getConnection() throws SQLException
    {
        Connection con = (Connection)DriverManager.getConnection(url,id,passwd);
        return con;
    }
    
    public void close()
    {
      
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("error/con");
            logger.error("close", e.getStackTrace());
        }
    }
    
    public void insert(String sql)
    {
        try{
            stmt =getConnection().createStatement();
            stmt.execute(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("error/inser");
        }
    }
    
}







