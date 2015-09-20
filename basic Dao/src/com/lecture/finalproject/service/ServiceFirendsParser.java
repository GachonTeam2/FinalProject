package com.lecture.finalproject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.lecture.finalproject.model.ModelFriends;

public class ServiceFirendsParser implements IServiceParser {
    private static Logger logger = LoggerFactory
                                         .getLogger(ServiceFirendsParser.class);

    @Override
    public String jsonFileReader(String URL) {

        String row;
        String result ="";

        try {
         
            BufferedReader in = new BufferedReader(new FileReader(URL));
         
            
            while ((row = in.readLine()) != null) {
    
                result += row + "\n";
           
                  }

                  //다 뽑아먹었으니 버퍼리더를 닫아 준다.
                  in.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("jsonFileReader", e.getStackTrace());
        }

        return result;
    }
    
    @Override
    public List<ModelFriends> jsonParsing(String jsonData) {
        // TODO Auto-generated method stub
        
        List<ModelFriends> result = new   ArrayList<ModelFriends>();
        ServiceHttpRequest request = new ServiceHttpRequest();
        
        while(true){
            try {
                
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonData); 
                
                JSONObject errorObject = (JSONObject) jsonObject.get("error");
                
                if(errorObject != null){
                    logger.error((String)errorObject.get("message"));
                    break;
                }
                       
                JSONArray friendInfoArray = (JSONArray) jsonObject.get("data");
                         
                for(int i=0; i<friendInfoArray.size(); i++){
                    
                    JSONObject friendObject = (JSONObject) friendInfoArray.get(i);
                    ModelFriends one = new ModelFriends();
                    
                    one.setFriendName((String)friendObject.get("name"));
                    one.setFriend_id((String)friendObject.get("id"));
                    
                    result.add(one);
                }
             
                JSONObject nextPageObject = (JSONObject) jsonObject.get("paging");

                 if(nextPageObject != null)
                 {
                     String nextPageInfoURL = (String)nextPageObject.get("next");
                     jsonData =  request.makeHTTPPOSTRequest(nextPageInfoURL);
                    continue;
                 }
                 else
                     break;
               
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return result;
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
