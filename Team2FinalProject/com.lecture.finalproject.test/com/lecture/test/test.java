package com.lecture.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lecture.finalproject.dao.DaoTravlePlace;
import com.lecture.finalproject.dao.IDao;
import com.lecture.finalproject.model.ModelComment;
import com.lecture.finalproject.model.ModelConcern;
import com.lecture.finalproject.model.ModelFeature;
import com.lecture.finalproject.model.ModelFriends;
import com.lecture.finalproject.model.ModelHash;
import com.lecture.finalproject.model.ModelImage;
import com.lecture.finalproject.model.ModelInformation;
import com.lecture.finalproject.model.ModelLocation;
import com.lecture.finalproject.model.ModelPostFeatureTable;
import com.lecture.finalproject.model.ModelTravelPost;
import com.lecture.finalproject.service.IServiceParser;
import com.lecture.finalproject.service.ServiceFirendsParser;


public class test {
    private static Logger logger = LoggerFactory.getLogger(test.class);
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void test() {
        IServiceParser one = new ServiceFirendsParser();
        String jsonData;
        List<ModelFriends> result = null;
        
        jsonData = one.jsonFileReader("C:\\Users\\park\\Documents\\FinalProject\\Team2FinalProject\\WebContent\\sampleData\\friendsSample.txt");
        result =  one.jsonParsing(jsonData);
        
        if(result != null)
        {
            for(ModelFriends i : result)
                System.out.println(i);
            assertTrue(true);
        }
        else
            assertTrue(false);

    }
    @Test
    public void test1() {
 
        IDao one = new DaoTravlePlace();
            
       List<ModelConcern> result = null;
       result = one.getConcernList("123");
        
        if(result != null)
        {
            for(ModelConcern i : result)
                System.out.println(i);
            assertTrue(true);
        }
        else
            assertTrue(false);
    }
}
