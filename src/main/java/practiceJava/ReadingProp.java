package practiceJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadingProp {

	private static String urlString;
	private static ReadingProp readingProp;
	
	public static ReadingProp initializingProperties() {
		if(readingProp == null) {
			readingProp = new ReadingProp();
		}
		BufferedReader bufferedReader;
		Properties properties = new Properties();
		try {
			bufferedReader = new BufferedReader(new FileReader("configuration/config.properties"));
			properties.load(bufferedReader);
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
		urlString = properties.getProperty("url");
		return readingProp;
	}
	
	public String getUrl() {
		return urlString;
	}
}
