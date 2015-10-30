package com.lecture.finalproject.service;

import java.util.List;

import com.lecture.finalproject.model.ModelFrontTravlePost;

public interface IServiceRestProcess {
	

	abstract public List<ModelFrontTravlePost> listByLocation(String[] value);

	abstract public List<ModelFrontTravlePost> listBySortedLocation(String[] value, String standard);

}
