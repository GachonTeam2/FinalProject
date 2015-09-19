package com.lecture.finalproject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Jstart {
    private static Logger logger = LoggerFactory.getLogger(Jstart.class);
    
    public static void main(String[] args) {
       TravelParser tp = new TravelParser();
       tp.Parser();
        
    }
}
