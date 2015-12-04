package JTCL;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lecture.finalproject.model.ModelConcern;
import com.lecture.finalproject.model.ModelFeature;



public class JTCLHelper {

	
	public List<ModelConcern> getConcern(List<String> meaningWordList){
	
		ArrayList<ModelConcern> concern = new ArrayList<ModelConcern>();
		for(int i=0; i<TextCatDriver.getCategory(meaningWordList).size(); i++){
			ModelConcern con = new ModelConcern();
			con.setInterest(TextCatDriver.getCategory(meaningWordList).get(i).toString());
			concern.add(con);
		}
		
		return concern;
	}
	
	public List<ModelFeature> getFeature(List<String> meaningWordList){
		
		
		ArrayList<ModelFeature> feature = new ArrayList<ModelFeature>();
		for(int i=0; i<TextCatDriver.getCategory(meaningWordList).size(); i++){
			ModelFeature feat = new ModelFeature();
			feat.setFeature(TextCatDriver.getCategory(meaningWordList).get(i).toString());
			feature.add(feat);
		}
		
		return feature;
	}
	
}
	