package com.lecture.finalproject.service;

import java.util.HashMap;
import java.util.Map;

import twitter4j.ResponseList;
import twitter4j.User;

public class ServiceGetWeight {
	
	private ResponseList<User> friendsUserObject;
	
	public ServiceGetWeight(ResponseList<User> friendsUserObject){
		this.friendsUserObject = friendsUserObject;
	}
	
	public Map<String, Float> getFriendsWeight(){
		
		Map<String,Float> friendNameAandWeight = new HashMap<String,Float>();
		float weight = 0;
		
		for(User user : friendsUserObject){
			weight = getFamiliarity(user);
			friendNameAandWeight.put(user.getName(), weight);
		}
		
		return friendNameAandWeight;
	}
	
	private float getFamiliarity(User user){
		
		float result = 0;
		
		result += getRetwittWeight(user);
		result += getCommentAndlikeWeight(user);
		result += getCommonFriendsWeight(user);
	
		return result;
	}
	
	private float getRetwittWeight(User user){
		
		float result = 0;
		
		result += getTextWeight(user);
		result += getPhotoWeight(user);
		result += getVideoWeight(user);
	
		return result;
	}
	
	private float getTextWeight(User user){
		float result = 0;
		
		return result;
	}
	
	private float getPhotoWeight(User user){
		float result = 0;
		
		return result;
	}
	
	private float getVideoWeight(User user){
		float result = 0;
		
		return result;
	}
	
	private float getCommentAndlikeWeight(User user){
		float result = 0;
		
		result += getCommentWeight(user);
		result += getLikeWeight(user);
		
		return result;
	}
	
	private float getCommentWeight(User user){
		float result = 0;
		
		
		
		return result;
	}
	
	private float getLikeWeight(User user){
		float result = 0;
		
		return result;
	}
	
	private float getCommonFriendsWeight(User user){
		float result = 0;
		
		return result;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
