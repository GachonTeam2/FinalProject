/**
 * 
 */

package JTCL;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author audumbar
 *
 */

public class TextCatDriver {
	/**
	 * @param args
	 */
	
	public static String getCategory(List<String> meaningWordList) {
		
		String s = "";

		for(int i=0; i<meaningWordList.size(); i++){
			s += meaningWordList.get(i);
			s += "\n";
		}
		
		TextCategorizer guesser = new TextCategorizer();  
		guesser.setConfFiles("C:\\Users\\park\\Documents\\FinalProject\\boot_test\\resource\\fingerPrinter\\textcat.conf");
		
		return guesser.categorize(s);
	}

	public static void createFP() {
		FingerPrint fp = new FingerPrint();

		try {
			fp.create(new File("����.txt"));
			fp.setCategory("����");
			fp.save();
		}

		catch(Exception e) {
		}
	}
}