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
	private User user;
	private float retweet;
	private float comment;
	private float mention;
	private float like;

	public FriendsInfoHelper(Twitter twitter, User myUser){
		this.twitter = twitter;	
		this.user = myUser;
		retweet = 0;
		comment = 0;
		mention = 0;
		like = 0;
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
			ResponseList<User> friendUserObject = twitter.lookupUsers(friendNames); // 나의 친구들의 user객체를 얻어옴
			
			for(User user : friendUserObject){
				
				System.out.println("Friend's Name " + user.getName());
				if(user.getStatus() != null){
					
					List<Status> statusess = twitter.getUserTimeline(user.getId()); //나의 timeline에서 해당 user가 적어놓은 timeline을 가져옴/statusess 하나는 timeline 하나를 의미
				

					 for (Status status3 : statusess) {
					 System.out.println(status3);
						 	checkWeight(status3,user);
						 	}
					 
					weight = getTotalWeight();
					friendsNameAndWeight.put(user.getName(), weight);
				}
				
				retweet = 0;
				comment = 0;
				mention = 0;
				like = 0;
			}
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());	
		}
		return friendsNameAndWeight;
	}
	
	private float getTotalWeight(){
		float result = 0;	
		result = retweet + comment + mention + like;
		
		return result;
	}
	
	private void checkWeight(Status inputTimeline, User friendUser){
		
		if(isRetweet(inputTimeline, friendUser)){
			retweet += checkRetweetWeight(inputTimeline);
			checkReTweetFavoriteWeight(inputTimeline);
		}else if(isComment(inputTimeline,friendUser)){
			comment += checkCommentWeight(inputTimeline);
			checkOtherFavortieWeight(inputTimeline);
		}else if(isMention(inputTimeline, friendUser)){
			mention += checkMentionWeight(inputTimeline);
			checkOtherFavortieWeight(inputTimeline);
		}
	}
	
	private void checkReTweetFavoriteWeight(Status inputTimeline){
		
		boolean isEqualLike = false;
			
		if(inputTimeline.getQuotedStatus().isFavorited())
			isEqualLike = true;
		
		if(inputTimeline.isFavorited())
		{
			if(isEqualLike)
				like += 0.2;
			else
				like += 0.1;
		}
	}
	
	private void checkOtherFavortieWeight(Status inputTimeline){
		if(inputTimeline.isFavorited())
			like += 0.1;
	}
	
	private float checkRetweetWeight(Status inputTimeline){
		float result = 0;
		
		if(inputTimeline.getQuotedStatus().getMediaEntities().length != 0){
			if(inputTimeline.getQuotedStatus().getMediaEntities()[0].getExpandedURL().contains("photo"))
				result += 0.8;
			else if(inputTimeline.getQuotedStatus().getMediaEntities()[0].getExpandedURL().contains("video"))
				result += 1.0;
		}else
			result += 0.5;
		return result;
	}
	
	private float checkCommentWeight(Status inputTimeline){
		float result = 0; result += 0.5;
		return result;
	}
	
	private float checkMentionWeight(Status inputTimeline){
		float result = 0;
		
		if(inputTimeline.getMediaEntities().length != 0){
			if(inputTimeline.getMediaEntities()[0].getExpandedURL().contains("photo"))
				result += 1.0;
			else if(inputTimeline.getMediaEntities()[0].getExpandedURL().contains("video"))
				result += 1.2;
		}else
			result += 0.7;
		
		return result;
	}
	
	
	private boolean isRetweet(Status inputTimeline, User friendUser){
		
		if(inputTimeline.getQuotedStatusId() != -1)
			return true;
		return false;
	}
	
	private boolean isComment(Status inputTimeline, User friendUser){
		if(inputTimeline.getInReplyToStatusId() != -1){
			if(inputTimeline.getInReplyToScreenName().equalsIgnoreCase(user.getScreenName()) || inputTimeline.getInReplyToScreenName().equalsIgnoreCase(friendUser.getScreenName()))
				return true;
		}
		
		return false;
	}
	
	private boolean isMention(Status inputTimeline, User friendUser){
		if(inputTimeline.getInReplyToStatusId() == -1){
			if(inputTimeline.getInReplyToScreenName() == null)
				return false;
			if(inputTimeline.getInReplyToScreenName().equalsIgnoreCase(user.getScreenName()))
				return true;
		}
		return false;
	}
	
	private Map<String,Float> getWeightRatio(Map<String, Float> friendsWeight, String[] friendNames){
		
		Map<String,Float> resultWeight = new HashMap<String,Float>();
		float totalWeight = 0;
		
		try {
			ResponseList<User> friendUserObject = twitter.lookupUsers(friendNames); // 나의 친구들의 user객체를 얻어옴
			
			for(User user : friendUserObject){
				totalWeight += friendsWeight.get(user.getName());
			}
			
			for(User user : friendUserObject){
				resultWeight.put(user.getName(), (friendsWeight.get(user.getName()) / totalWeight) * 100);
			}
			
		}catch(TwitterException e){
			System.out.println(e.getMessage());
		}
		
		return resultWeight;
	}
}
