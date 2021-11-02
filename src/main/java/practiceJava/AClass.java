package practiceJava;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AClass {

	public void test(Object obj) {
		System.out.println("This is a test : " + obj);
	}

	public static void main(String[] args) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String date1 = dateFormat.format(new Date());
		System.out.println(date1);

	}

}
