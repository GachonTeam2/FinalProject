package com.lecture.finalproject.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class ServiceFirendsParser implements IServiceParser {
    private static Logger logger = LoggerFactory
                                         .getLogger(ServiceFirendsParser.class);

    @Override
    public String jsonFileReader(String URL) {
       
        InputStream is = getClass().getClassLoader().getResourceAsStream(URL);
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));

        String row;
        String result ="";

        try {
            while ((row = bf.readLine()) != null) {
                result += row +"\n";
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("jsonFileReader", e.getStackTrace());
        }

        return result;
    }
    
    
    
    
    
    
    
    
    
}
