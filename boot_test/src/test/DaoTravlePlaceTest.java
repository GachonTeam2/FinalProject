package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lecture.finalproject.dao.DaoTravlePlace;
import com.lecture.finalproject.model.ModelConcern;
import com.lecture.finalproject.model.ModelInformation;
import com.lecture.finalproject.model.ModelTravelPost;

public class DaoTravlePlaceTest {

	@Test
	public void test() {
		DaoTravlePlace one = new DaoTravlePlace();
		int count = 0;
		ModelTravelPost result = null;
		
		result = one.getTravelPostOne(1);
				
		
		System.out.println(result);
		
	}

}
