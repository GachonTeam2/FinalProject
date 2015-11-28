package JTCL;

import java.util.List;
import java.util.Map;

import com.lecture.finalproject.model.ModelConcern;
import com.lecture.finalproject.model.ModelFeature;



public class JTCLHelper {

	public String interest[] = {"미식","낚시","바다","캠핑","등산","섬","레저"};
	public double[] getConcernDistance(String meaingWordList){
	
		TextCategorizer guesser = new TextCategorizer();  
		guesser.setConfFiles("textcat.conf");
		//System.out.println(guesser.categorize(s));
		//System.out.println(guesser.getCategoryDistances(s));
		
		//친구 한명의 글을 가져와서 그 글에 대한 관심사와 가중치를 배열로 나열
		Map<String, Integer> a = guesser.getCategoryDistances(meaingWordList);
		String b = a.toString();
		System.out.println();
		
		
		String c = a.values().toString();
		System.out.println(b);
		String e = (String) c.subSequence(1, c.length()-1);
		String[] d = e.split(", ");
		int realWeight[] = {1,2,3,4,5,6,7};
		double df[] ={1,2,3,4,5,6,7};
		double sum=0;
		double sum2=0;
		
		for(int i=0;i<d.length;i++){
			d[i].trim();
			//System.out.println(d[i]);
			realWeight[i] = Integer.parseInt(d[i]);
			sum+=realWeight[i];
			//System.out.println(realWeight.length);
		}
		
		for(int i=0;i<realWeight.length;i++)
		{
			
			
			df[i] = (1/((realWeight[i]/sum)*100.0))*100;
			//System.out.println(realWeight[i]+" "+ df[i]);
			sum2+=df[i];
			
		}
		sum=0;
		for(int i=0;i<realWeight.length;i++)
		{
			df[i] = (df[i]/sum2)*100;
			System.out.println(realWeight[i]+" "+ df[i]);
			sum+=df[i];
		}
		System.out.println(sum);
	
		return df;
		
		
	}
	
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
	