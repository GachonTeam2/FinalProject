package JTCL;

import java.util.List;

import com.lecture.finalproject.model.ModelConcern;

public class JTCLHelper {
	
	public ModelConcern getConcern(List<String> meaingWordList){
	
		ModelConcern concern = new ModelConcern();
		
		concern.setInterest(TextCatDriver.getCategory(meaingWordList));
		
		return concern;
	}

}
	