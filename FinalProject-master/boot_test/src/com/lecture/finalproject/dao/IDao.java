package com.lecture.finalproject.dao;

import java.util.List;
import java.util.Map;

import com.lecture.finalproject.model.ModelComment;
import com.lecture.finalproject.model.ModelConcern;
import com.lecture.finalproject.model.ModelFeature;
import com.lecture.finalproject.model.ModelFrontTravlePost;
import com.lecture.finalproject.model.ModelHash;
import com.lecture.finalproject.model.ModelImage;
import com.lecture.finalproject.model.ModelInformation;
import com.lecture.finalproject.model.ModelLocation;
import com.lecture.finalproject.model.ModelTravelPost;
import com.lecture.finalproject.model.ModelUser;



public interface IDao {
	
	public abstract ModelUser getUserInfo(String user_id);
	
	public abstract int insertUserInfo(ModelUser user);
	
	public abstract int getUserCount(String user_id);
	
	
	//front Travle List 가져오기
	public abstract List<ModelFrontTravlePost> getFrontTravlePostList();
	//front Travle List 위치기반
	public abstract List<ModelFrontTravlePost> getFrontTravlePostListByLocation(String[] location);
	 //front Travle sorted List 위치 기반
	public List<ModelFrontTravlePost> getFrontTravlePostListBySortedLocation(String[] location, String standard);
	//front Travle List Id기반
	public List<ModelFrontTravlePost> getFrontTravlePostListById(String user_id);
	
	//여행지 List, 여행지 하나 가져오기

    public abstract List<ModelTravelPost> getTravelPostList(String user_id);
    public abstract ModelTravelPost getTravelPostOne(int travelPost_no);
    
    
    public abstract ModelLocation getLocationOne(int travelPost_no);
    
    public abstract List<ModelImage> getImageList(int travelPost_no);
    
    public abstract List<ModelComment> getCommentList(int travelPost_no);
    
    public abstract int getLikeCount(int travelPost_no);
    
    
    //여행지에 대한 설명 정보 
    public abstract List<ModelInformation> getInformationList(int travelPost_no);
    public abstract ModelInformation getInformation(int travelPost_no);
    
    
    public abstract List<ModelHash> getHashList(int travelPost_no);
    
    public abstract List<ModelFeature> getFeatureList(int travelPost_no);
    
    
    //관심사 동기화 
    public abstract List<ModelConcern> getConcernList(String user_id);
    public abstract int insertConcern(ModelConcern concernList);
    public abstract int updateSyncState(String user_id);
    
   
    
   
    
    
    

}
