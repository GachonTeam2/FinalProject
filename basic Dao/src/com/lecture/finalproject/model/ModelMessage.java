package com.lecture.finalproject.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ModelMessage {
    private static Logger logger = LoggerFactory.getLogger(ModelMessage.class);
    
    private String message;

    public ModelMessage() {
        super();
    }

    public ModelMessage(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ModelMessage [message=" + message + "]";
    }
    
    
}
