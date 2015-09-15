package com.lecture.finalproject.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ModelFriends {
    private static Logger logger = LoggerFactory.getLogger(ModelFriends.class);
    
    private String user_id     ;
    private String friend_id   ;
    private String friendName  ;
    public ModelFriends(String user_id, String friend_id, String friendName) {
        super();
        this.user_id = user_id;
        this.friend_id = friend_id;
        this.friendName = friendName;
    }
    public ModelFriends() {
        super();
    }
    public static Logger getLogger() {
        return logger;
    }
    public static void setLogger(Logger logger) {
        ModelFriends.logger = logger;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getFriend_id() {
        return friend_id;
    }
    public void setFriend_id(String friend_id) {
        this.friend_id = friend_id;
    }
    public String getFriendName() {
        return friendName;
    }
    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }
    @Override
    public String toString() {
        return "ModelFriends [user_id=" + user_id + ", friend_id=" + friend_id
                + ", friendName=" + friendName + "]";
    }
 
}
