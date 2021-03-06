package com.lecture.finalproject.service;

import java.util.List;

import com.lecture.finalproject.dao.DaoTravlePlace;
import com.lecture.finalproject.model.ModelConcern;
import com.lecture.finalproject.model.ModelUser;

import JTCL.JTCLHelper;
import JTCL.TextCatDriver;
import Komoran.Preprocessor;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

public class ServiceInfoSynchronize {

	public boolean isSynchronize(ModelUser inputUser){

		DaoTravlePlace checker = new DaoTravlePlace();	
		return checker.getUserInfo(inputUser.getUser_id()).isSync();	
	}

	public boolean synchronize(Twitter twitter){

		int result = 0;
		int result1 = 0;
		String str="";
		User user = null;

		List<String> meaningWordList = null;	
		List<String> timelineList = null;
		List<ModelConcern> concern = null;

		ServiceTwitterParser parser = new ServiceTwitterParser();	
		DaoTravlePlace uploader = new DaoTravlePlace();
		Preprocessor processor = new Preprocessor();
		JTCLHelper concernHelper = new JTCLHelper();

		try {
			user = twitter.verifyCredentials();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//전처리 후 의미있는 NNP, NNG list를 받아옴
		timelineList = parser.getMyTimeline(twitter);
		str = processor.timeLineToString(timelineList);
		str = processor.preProcess(str);
		meaningWordList = processor.getMeaningWord(str);

		//List를 JTCL에 넣어준다
		concern = concernHelper.getConcern(meaningWordList);
		for(int i=0;i<concern.size();i++)
		{
			concern.get(i).setUser_id(Long.toString(user.getId()));

			result = uploader.insertConcern(concern.get(i));
		}
		
		result1 = uploader.updateSyncState(Long.toString(user.getId()));

		if(result * result1 > 0)
			return true;
		return false;
	}

}
