package practiceJava;

import java.io.IOException;
import java.text.ParseException;

public class AClass {

	public void test(Object obj) {
		System.out.println("This is a test : " + obj);
	}

	public static void main(String[] args) throws ParseException, IOException {
		ReadingProp readingProp = ReadingProp.initializingProperties();
		System.out.println(readingProp.getUrl());
	}

}
