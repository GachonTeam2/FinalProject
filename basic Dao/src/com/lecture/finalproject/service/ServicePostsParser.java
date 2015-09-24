package com.lecture.finalproject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lecture.finalproject.model.ModelFriends;
import com.lecture.finalproject.model.ModelMessage;


public class ServicePostsParser implements IServiceParser{
    private static Logger logger = LoggerFactory
                                         .getLogger(ServicePostsParser.class);
    @Override
    public String jsonFileReader(String URL) {

        String row;
        String result ="";

        try {
         
            BufferedReader in = new BufferedReader(new FileReader(URL));
         
            
            while ((row = in.readLine()) != null)   
                result += row + "\n";
           
                  in.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("jsonFileReader", e.getStackTrace());
        }
        return result;
    }
    
    @Override
    public List<Object> jsonParsing(String jsonData) {
        // TODO Auto-generated method stub
        
        List<Object> result = new ArrayList<Object>();
        
        while(true){
            try {
                
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject;
            
                 jsonObject = (JSONObject) jsonParser.parse(jsonData);
              
                JSONArray PostInfoArray = (JSONArray) jsonObject.get("data");
                
               
                for(int i=0; i<PostInfoArray.size(); i++){
                    
                
                    JSONObject friendObject = (JSONObject) PostInfoArray.get(i);
                    String temp = (String)friendObject.get("message");
                    
                    if(temp != null)
                    {              
                        ModelMessage one = new ModelMessage();
                        one.setMessage(temp);                   
                        result.add(one);
                   }
                }
             
                JSONObject nextPageObject = (JSONObject) jsonObject.get("paging");

                 if(nextPageObject != null)
                 {
                     String nextPageInfoURL = (String)nextPageObject.get("next");
                     
                     try{     

                         URL url = new URL(nextPageInfoURL);
                         HttpURLConnection request1 = (HttpURLConnection) url.openConnection();
                         request1.setRequestMethod("GET");
                         request1.connect();
                         InputStream is = request1.getInputStream();
                         BufferedReader bf_reader = new BufferedReader(new InputStreamReader(is));
                         StringBuilder sb = new StringBuilder();
                         String line = "";
                         jsonData = "";
                         
                         while ((line = bf_reader.readLine()) != null) {
                             sb.append(line).append("\n");
                         }               
                         
                         jsonData = sb.toString();
                     } catch(Exception e){
                         e.printStackTrace();
                     }      
                     
                    continue;
                 }
                 else{             
                     break;
                 }
               
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
        }
        
        return result;
        
    }

}
