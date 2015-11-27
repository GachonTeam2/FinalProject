package JTCL;

import java.util.List;

import com.lecture.finalproject.model.ModelConcern;
import com.lecture.finalproject.model.ModelFeature;

public class JTCLHelper {
	
	public ModelConcern getConcern(List<String> meaingWordList){
	
		ModelConcern concern = new ModelConcern();
		
		concern.setInterest(TextCatDriver.getCategory(meaingWordList));
		
		return concern;
	}
	
	public ModelFeature getFeature(List<String> meaningWordList){
		
		ModelFeature feature = new ModelFeature();
		
		feature.setFeature(TextCatDriver.getCategory(meaningWordList));
		
		return feature;
	}
}
	