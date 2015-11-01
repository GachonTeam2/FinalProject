package com.lecture.finalproject.service;

import java.util.List;

import com.lecture.finalproject.dao.DaoTravlePlace;
import com.lecture.finalproject.model.ModelFrontTravlePost;

public class ServiceRestProcessByLocation implements IServiceRestProcess{

	private DaoTravlePlace db = new DaoTravlePlace();

	@Override
	public List<ModelFrontTravlePost> listByLocation(String[] value) {
		List<ModelFrontTravlePost> result = db.getFrontTravlePostListByLocation(value);
		return result;
	}
	
	@Override
	public List<ModelFrontTravlePost> listBySortedLocation(String[] value, String standard) {		
		List<ModelFrontTravlePost> result = db.getFrontTravlePostListBySortedLocation(value, standard);
		return result;
	}


	
	
	
}
