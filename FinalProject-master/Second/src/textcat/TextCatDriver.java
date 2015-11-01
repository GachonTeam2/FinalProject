/**
 * 
 */

package textcat;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author audumbar
 *
 */

public class TextCatDriver {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		createFP();
		printCategory();
	}
	
	public static void printCategory() {
		char[] data = new char[1024];
		int read;
		String s = "";

		try {
			FileReader fr = new FileReader(new File("test3.txt"));
			while ((read = fr.read(data)) != -1) {
				s += new String(data, 0, read);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		TextCategorizer guesser = new TextCategorizer();  
		guesser.setConfFiles("textcat.conf");
		System.out.println(guesser.categorize(s));
	}

	public static void createFP() {
		FingerPrint fp = new FingerPrint();

		try {
			fp.create(new File("³¬½Ã.txt"));
			fp.setCategory("³¬½Ã");
			fp.save();
		}

		catch(Exception e) {
		}
	}
}