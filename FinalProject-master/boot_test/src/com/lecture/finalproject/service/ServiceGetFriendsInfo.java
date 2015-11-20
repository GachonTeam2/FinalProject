package com.lecture.finalproject.service;

import java.util.List;

import com.lecture.finalproject.model.ModelUser;

import twitter4j.PagableResponseList;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

public class ServiceGetFriendsInfo {

	public void getFriendAndFollowerList(Twitter twitter, List<ModelUser> listFriends){
		
		   try {
	            long cursor = -1;
	            PagableResponseList<User> pagableFollowings;
	            do {
	            	
	                pagableFollowings = twitter.getFriendsList(twitter.getId(), cursor);
	                for (User user : pagableFollowings) {
	                	ModelUser friend = new ModelUser(Long.toString(user.getId()), user.getName(), user.getProfileImageURL(),false);
	                	
	                    listFriends.add(friend); // ArrayList<User>
	                }
	            } while ((cursor = pagableFollowings.getNextCursor()) != 0);

	        } catch (TwitterException e) {
	        	System.out.println(e.getMessage());
	        }
	}
		
	public  ResponseList<User> getFriendsObject(Twitter twitter, String[] friendNames){
		ResponseList<User> users = null;
		
		try{
			 users = twitter.lookupUsers(friendNames);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return users;
	}
	
	
}
