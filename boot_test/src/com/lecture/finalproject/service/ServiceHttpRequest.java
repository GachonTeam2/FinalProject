package com.lecture.finalproject.service;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.util.Map;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ServiceHttpRequest {
    private static Logger logger = LoggerFactory
                                         .getLogger(ServiceHttpRequest.class);
    
    public String makeHTTPPOSTRequest(String url)
    {

        String result ="";
        HttpClient httpclient = new DefaultHttpClient();
        try {
            // HttpGet생성
            HttpPost post = new HttpPost(url);
     
            HttpResponse response = httpclient.execute(post);
            HttpEntity entity = response.getEntity();
 
            if (entity != null) {
           
                BufferedReader rd = new BufferedReader(new InputStreamReader(
                        entity.getContent()));
 
                String line = "";
                
                while ((line = rd.readLine()) != null) {
                    result += line +"\n";
                }
            }
      
            httpclient.getConnectionManager().shutdown();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
        
        return result; 
    }
}
