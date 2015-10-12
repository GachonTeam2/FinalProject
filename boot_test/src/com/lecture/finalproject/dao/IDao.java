package com.lecture.finalproject.dao;

import java.util.List;

import com.lecture.finalproject.model.ModelComment;
import com.lecture.finalproject.model.ModelConcern;
import com.lecture.finalproject.model.ModelFeature;
import com.lecture.finalproject.model.ModelHash;
import com.lecture.finalproject.model.ModelImage;
import com.lecture.finalproject.model.ModelInformation;
import com.lecture.finalproject.model.ModelLocation;
import com.lecture.finalproject.model.ModelPostFeatureTable;
import com.lecture.finalproject.model.ModelTravelPost;



public interface IDao {
    
    public abstract List<ModelTravelPost> getTravelPostList(String user_id);
    
    public abstract ModelLocation getLocationOne(int travelPost_no);
    
    public abstract List<ModelPostFeatureTable> getPostFeatureTableList(int travelPost_no);
    
    public abstract List<ModelImage> getImageList(int travelPost_no);
    
    public abstract List<ModelComment> getCommentList(int travelPost_no);
    
    public abstract int getLikeCount(int travelPost_no);
    
    public abstract List<ModelInformation> getInformationList(int travelPost_no);
    
    public abstract List<ModelHash> getHashList(int travelPost_no);
    
    public abstract List<ModelFeature> getFeatureList(int travelPost_no);
     
    public abstract List<ModelConcern> getConcernList(String user_id);
    
    
    

}