package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lecture.finalproject.dao.DaoTravlePlace;
import com.lecture.finalproject.model.ModelConcern;
import com.lecture.finalproject.model.ModelFrontTravlePost;
import com.lecture.finalproject.model.ModelInformation;
import com.lecture.finalproject.model.ModelTravelPost;

public class DaoTravlePlaceTest {

	@Test
	public void test() {
		DaoTravlePlace one = new DaoTravlePlace();
		int count = 0;
		List<ModelFrontTravlePost> result = null;
		
		result = one.getFrontTravlePostList();
				
		
		System.out.println(result);
		
	}

}
