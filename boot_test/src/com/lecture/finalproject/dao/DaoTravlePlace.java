package com.lecture.finalproject.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;

import com.lecture.finalproject.model.ModelComment;
import com.lecture.finalproject.model.ModelConcern;
import com.lecture.finalproject.model.ModelFeature;
import com.lecture.finalproject.model.ModelHash;
import com.lecture.finalproject.model.ModelImage;
import com.lecture.finalproject.model.ModelInformation;
import com.lecture.finalproject.model.ModelLocation;
import com.lecture.finalproject.model.ModelPostFeatureTable;
import com.lecture.finalproject.model.ModelTravelPost;
import com.lecture.finalproject.model.ModelUser;


public class DaoTravlePlace implements IDao{
    
  
    private static Connection connection = JDBCMannager.getInstance();
   
    private Statement st = null;
    private ResultSet rs = null;
    private PreparedStatement pstmt = null;
    
    @Override
    public int updateSyncState(String user_id) {
    	
    	int result = 0;
    	
    	try{
    		String query = "UPDATE user_tb SET sync=? where user_id =?";
    		
    		pstmt = connection.prepareStatement(query);
    		pstmt.setInt(1, 1);
    		pstmt.setString(2, user_id);
    				
    		result = pstmt.executeUpdate();
    	}catch(SQLException e){
    		System.out.println(e.getMessage());
    	}
    	
    	return result;
    }
    
    
    @Override
    public ModelUser getUserInfo(String user_id) {
    	
    	ModelUser result = null;
    	
    	try{
    		String query = "select * from user_tb where user_id = '" + user_id + "'";
    		
    		st = connection.createStatement();
    		rs = st.executeQuery(query);
    		
    		  while (rs.next()) {
    			  result = new ModelUser(rs.getString("user_id"),rs.getString("name"),rs.getString("img_url"),rs.getBoolean("sync"));
              }
    		
    	}catch(SQLException e){
    		System.out.println(e.getMessage());
    	}
    	
    	
    	return result;
    }
    
    @Override
    public int insertUserInfo(ModelUser user) {
    	// TODO Auto-generated method stub
    	
    	int result = 0;
    	
    	try{
    		
    		String query = "insert into user_tb value(?,?,?,?)";     // sql 쿼리
    		pstmt = connection.prepareStatement(query);                          // prepareStatement에서 해당 sql을 미리 컴파일한다.
    		pstmt.setString(1,user.getUser_id());
    		pstmt.setString(2,user.getName());
    		pstmt.setString(3,user.getImg_url());
    		pstmt.setBoolean(4,user.isSync());
    		
    		result = pstmt.executeUpdate();
    	
    	}catch(SQLException e){
    		System.out.println(e.getMessage());
    	}

    	return result;
    }
    
    @Override
    public int getUserCount(ModelUser user) {
    	// TODO Auto-generated method stub
    	
    	int result = 0;
    	
    	try{
    		String query = "select count(*) from user_tb where user_id = ?";
    		
    		pstmt = connection.prepareStatement(query);
    		pstmt.setString(1, user.getUser_id());
    		
    		rs = pstmt.executeQuery();
    		rs.next();
    		result = rs.getInt(1);
    		
    	}catch(SQLException e){
    		System.out.println(e.getMessage());
    	}
    		
      	return result;
      	
    }
    
  
    @Override
    public List<ModelTravelPost> getTravelPostList(String user_id) {
        // TODO Auto-generated method stub
      
        List<ModelTravelPost> result = new ArrayList<ModelTravelPost>();
        
        try {
            String query = "select * from travelpost_tb where user_id = '" + user_id + "';";
            st = connection.createStatement();
            rs =st.executeQuery(query);
            
            if(st.execute(query))
                rs = st.getResultSet();
              
            while (rs.next()) {
                ModelTravelPost one = new ModelTravelPost();
                
                one.setTravelPost_no(rs.getInt("travelPost_no"));
                one.setTitle(rs.getString("title"));
                one.setTravelPost_date(rs.getString("travelPost_date"));
                one.setView_count(rs.getInt("view_count"));
                one.setLike_count(rs.getInt("like_count"));
                one.setUser_id(rs.getString("user_id"));
                
                result.add(one);
            }
          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         
        }
        return result;
    }
    
    @Override
    public ModelLocation getLocationOne(int travelPost_no) {
        // TODO Auto-generated method stub
        ModelLocation result = null;
        
        try {
            String query = "select * from location_tb where travelPost_no ='" + travelPost_no + "';";
            st = connection.createStatement();
            rs =st.executeQuery(query);
            
            if(st.execute(query))
                rs = st.getResultSet();
              
            while (rs.next()) {
                result = new ModelLocation();
                
                result.setCity1(rs.getString("city1"));
                result.setCity2(rs.getString("city2"));
                result.setAddress(rs.getString("address"));
                result.setLatitude(rs.getString("latitude"));
                result.setLongitude(rs.getString("longitude"));
                result.setTravelPost_no(rs.getInt("travelPost_no"));
            }
          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          
        }
        return result;
        
    }
    
    @Override
    public List<ModelPostFeatureTable> getPostFeatureTableList(int travelPost_no) {
        // TODO Auto-generated method stub
        
        List<ModelPostFeatureTable> result = new ArrayList<ModelPostFeatureTable>();
        
        try {
            String query = "select * from postfeaturetable_tb where travelPost_no = '" + travelPost_no + "';";
            st = connection.createStatement();
            rs =st.executeQuery(query);
            
            if(st.execute(query))
                rs = st.getResultSet();
              
            while (rs.next()) {
                ModelPostFeatureTable one  = new ModelPostFeatureTable();
                
                one.setTable_name(rs.getString("table_name"));
                one.setTravelPost_no(rs.getInt("travelPost_no"));       
                
                result.add(one);
            }
          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
   
        }
        return result;
    }
    
    @Override
    public List<ModelImage> getImageList(int travelPost_no) {
    
        List<ModelImage> result = new ArrayList<ModelImage>();
        
        try {
            String query = "select * from image_tb where travelPost_no = '" + travelPost_no + "';";
            st = connection.createStatement();
            rs =st.executeQuery(query);
            
            if(st.execute(query))
                rs = st.getResultSet();
              
            while (rs.next()) {
                ModelImage one  = new ModelImage();
                
                one.setImage_url(rs.getString("image_url"));
                one.setTravelPost_no(rs.getInt("travelPost_no"));       
                
                result.add(one);
            }
          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
       
        }
        return result;
    }
    
    @Override
    public List<ModelComment> getCommentList(int travelPost_no) {
        // TODO Auto-generated method stub
    
        List<ModelComment> result = new ArrayList<ModelComment>();
        
        try {
            String query = "select * from comment_tb where travelPost_no= '" + travelPost_no + "';";
            st = connection.createStatement();
            rs =st.executeQuery(query);
            
            if(st.execute(query))
                rs = st.getResultSet();
              
            while (rs.next()) {
                ModelComment one  = new ModelComment();
                
                one.setComment_no(rs.getInt("comment_no"));
                one.setCommentPost_date(rs.getString("commentPost_date"));
                one.setContent(rs.getString("content"));
                one.setUser_id(rs.getString("user_id"));                
                one.setTravelPost_no(rs.getInt("travelPost_no"));       
                
                result.add(one);
            }
          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
      
        }
        return result;
    }
    
    @Override
    public int getLikeCount(int travelPost_no) {
        // TODO Auto-generated method stub
        
        int result = 0;
        
        try {
            String query = "select count(user_id) from like_tb where travelPost_no = '" + travelPost_no + "';";
            st = connection.createStatement();
            rs =st.executeQuery(query);
            
            if(st.execute(query))
                rs = st.getResultSet();
              
            while (rs.next()) {
                result = rs.getInt(1);
            }
          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return result;
    }
    
    @Override
    public List<ModelInformation> getInformationList(int travelPost_no) {

        List<ModelInformation> result = new ArrayList<ModelInformation>();
        
        try {
            String query = "select * from information_tb where travelPost_no = '" + travelPost_no + "';";
            st = connection.createStatement();
            rs =st.executeQuery(query);
            
            if(st.execute(query))
                rs = st.getResultSet();
              
            while (rs.next()) {
                ModelInformation one = new ModelInformation();
                
                one.setTravel_content(rs.getString("travel_content"));
                one.setTravelPost_no(rs.getInt("travelPost_no"));
                
                result.add(one);
            }
          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    
        return result;
    }
    
    @Override
    public List<ModelHash> getHashList(int travelPost_no) {
        // TODO Auto-generated method stub

        List<ModelHash> result = new ArrayList<ModelHash>();
        
        try {
            String query = "select * from hash_tb where travelPost_no =  '" + travelPost_no + "';";
            st = connection.createStatement();
            rs =st.executeQuery(query);
            
            if(st.execute(query))
                rs = st.getResultSet();
              
            while (rs.next()) {
                ModelHash one = new ModelHash();
                
                one.setHashTag(rs.getString("hashTag"));
                one.setTravelPost_no(rs.getInt("travelPost_no"));
    
                result.add(one);
            }
          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
    
        }
    
        return result;
    
    }
    
    @Override
    public List<ModelFeature> getFeatureList(int travelPost_no) {
        // TODO Auto-generated method stub

        List<ModelFeature> result = new ArrayList<ModelFeature>();
        
        try {
            String query = "select * from feature_tb where travelPost_no= '" + travelPost_no + "';";
            st = connection.createStatement();
            rs =st.executeQuery(query);
            
            if(st.execute(query))
                rs = st.getResultSet();
              
            while (rs.next()) {
                ModelFeature one = new ModelFeature();
                
                one.setFeature(rs.getString("feature"));
                one.setTravelPost_no(rs.getInt("travelPost_no"));
    
                result.add(one);
            }
          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
       
        }
    
        return result;
        
    }
    
    @Override
    public List<ModelConcern> getConcernList(String user_id) {
        // TODO Auto-generated method stub
        
        List<ModelConcern> result = new ArrayList<ModelConcern>();
        
        try {
            String query = "select * from concern_tb where user_id ='" + user_id + "';";
            st = connection.createStatement();
            rs =st.executeQuery(query);
            
            if(st.execute(query))
                rs = st.getResultSet();
              
            while (rs.next()) {
                ModelConcern one = new ModelConcern();
                
                one.setInterest(rs.getString("interest"));
                one.setUser_id(rs.getString("user_id"));
    
                result.add(one);
            }
          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        	e.printStackTrace();
 
        }
    
        return result;
    }
	    
    
	 @Override
	public int insertConcern(ModelConcern concern) {
		// TODO Auto-generated method stub
		 
		 int result = 0;
		 
		 try{
			 String query = "insert into concern_tb values(?,?)";
				 
			 pstmt = connection.prepareStatement(query);
			 pstmt.setString(1, concern.getInterest());
			 pstmt.setString(2,concern.getUser_id());
			 
			 result = pstmt.executeUpdate();
		
		 }catch(SQLException e){
			 System.out.println(e.getMessage());
		 }
		 
		return result;
	}
	    
}
