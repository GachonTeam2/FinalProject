package com.lecture.finalproject.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lecture.finalproject.model.ModelUser;

import twitter4j.PagableResponseList;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

public class FriendsInfoHelper {
	
	private Twitter twitter;
	
	
	public FriendsInfoHelper(Twitter twitter){
		this.twitter = twitter;
	}
	
	public List<ModelUser> getFriendAndFollowerList(){
		
		List<ModelUser> friendList = new ArrayList<ModelUser>(0);
		
		   try {
	            long cursor = -1;
	            PagableResponseList<User> pagableFollowings;
	            do {
	            	
	                pagableFollowings = twitter.getFriendsList(twitter.getId(), cursor);
	                for (User user : pagableFollowings) {
	                	ModelUser friend = new ModelUser(Long.toString(user.getId()), user.getName(), user.getProfileImageURL(),false);
	                	
	                	friendList.add(friend); // ArrayList<User>
	                }
	            } while ((cursor = pagableFollowings.getNextCursor()) != 0);

	        } catch (TwitterException e) {
	        	System.out.println(e.getMessage());
	        }
		   
		   return friendList;
	}
		

	public Map<String, Float> getFriendsWeight(String[] friendNames) {
		
		Map<String, Float> friendsNameAndWeight = new HashMap<String, Float>();
		float weight;
		
		try {
			ResponseList<User> friendUserObject = twitter.lookupUsers(friendNames);
			
			for(User user : friendUserObject){
				
				if(user.getStatus() != null){
					
					List<Status> statusess = twitter.getUserTimeline(user.getName());
					
					System.out.println(statusess);
			
					weight = getFamiliarity(user);
					friendsNameAndWeight.put(user.getName(), weight);
				}
			}
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return friendsNameAndWeight;
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
		
		try {
			List<Status> statusess = twitter.getUserTimeline(user.getName());
			
		
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
