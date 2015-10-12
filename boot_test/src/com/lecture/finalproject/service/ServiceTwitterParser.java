package com.lecture.finalproject.service;

import java.util.ArrayList;
import java.util.List;

import twitter4j.IDs;
import twitter4j.PagableResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

public class ServiceTwitterParser{
	
	public ArrayList<User> getFriendsList(Twitter twitter) {
		// TODO Auto-generated method stub
		
		ArrayList<User> listFriends = new ArrayList<User>();
	
		 try {
	            // get friends
	            long cursor = -1;
	            PagableResponseList<User> pagableFollowings;
	            do {
	                pagableFollowings = twitter.getFriendsList(twitter.getId(), cursor);
	                for (User user : pagableFollowings) {
	                    listFriends.add(user); // ArrayList<User>
	                }
	            } while ((cursor = pagableFollowings.getNextCursor()) != 0);

	            // get followers
	           

	        } catch (TwitterException e) {
	           	System.out.println(e.getMessage());
	        }
			 
		return listFriends;
	}
	 
	public ArrayList<User> getFollowersList(Twitter twitter)
	{
		ArrayList<User> listFollowers = new ArrayList<User>();
		
		try {
			long cursor = -1;
			PagableResponseList<User> pagableFollowers;
			do {
				pagableFollowers = twitter.getFollowersList(twitter.getId(), cursor);
				for (User user : pagableFollowers) {
					listFollowers.add(user); // ArrayList<User>
				}
			} while ((cursor = pagableFollowers.getNextCursor()) != 0);
		} catch (TwitterException e) {
			System.out.println(e.getMessage());
		}
		
		return listFollowers;	
	}
}
