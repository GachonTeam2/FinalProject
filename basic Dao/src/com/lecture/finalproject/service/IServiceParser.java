package com.lecture.finalproject.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lecture.finalproject.model.ModelFriends;


public interface IServiceParser {
    
    public abstract String jsonFileReader (String URL);
    
    public abstract List<ModelFriends> jsonParsing(String jsonData); 
    
}
