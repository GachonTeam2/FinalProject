package com.lecture.finalproject.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;




import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.jdbc.Connection;

public class JDBCMannager {
    private static Logger logger = LoggerFactory.getLogger(JDBCMannager.class);
    
    public static Connection  connection = null;
    
    public static synchronized Connection getInstance() {

        if(connection == null) {
            
            try{
           
            connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject","root","root");
            }catch(SQLException e){
                logger.error(e.getMessage());
                logger.error(e.getSQLState());
            }           
        }
        
        return connection; 
    }
    
    
}
