package com.lecture.finalproject.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ModelComment {
    private static Logger logger = LoggerFactory.getLogger(ModelComment.class);
    
    private int comment_no             ;
    private Date commentPost_date      ;
    private String content             ;
    private String user_id             ;
    private int travelPost_no          ;
    public ModelComment(int comment_no, Date commentPost_date, String content,
            String user_id, int travelPost_no) {
        super();
        this.comment_no = comment_no;
        this.commentPost_date = commentPost_date;
        this.content = content;
        this.user_id = user_id;
        this.travelPost_no = travelPost_no;
    }
    public ModelComment() {
        super();
    }
    public static Logger getLogger() {
        return logger;
    }
    public static void setLogger(Logger logger) {
        ModelComment.logger = logger;
    }
    public int getComment_no() {
        return comment_no;
    }
    public void setComment_no(int comment_no) {
        this.comment_no = comment_no;
    }
    public Date getCommentPost_date() {
        return commentPost_date;
    }
    public void setCommentPost_date(Date commentPost_date) {
        this.commentPost_date = commentPost_date;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public int getTravelPost_no() {
        return travelPost_no;
    }
    public void setTravelPost_no(int travelPost_no) {
        this.travelPost_no = travelPost_no;
    }
    @Override
    public String toString() {
        return "ModelComment [comment_no=" + comment_no + ", commentPost_date="
                + commentPost_date + ", content=" + content + ", user_id="
                + user_id + ", travelPost_no=" + travelPost_no + "]";
    }
    
}
