package com.lecture.finalproject.dao;


import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lecture.finalproject.model.ModelTravelPost;


public class Travelpost_db {
    private static Logger logger = LoggerFactory.getLogger(Travelpost_db.class);
    ModelTravelPost tp = new ModelTravelPost();
    
    private Connection con = JDBCMannager.getInstance();
    private Statement stmt;

     
    public Connection getConnection() throws SQLException
    {
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
            stmt=getConnection().createStatement();
            stmt.execute(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("error/inser");
        }
    }
    
}







