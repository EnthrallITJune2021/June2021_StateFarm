package com.statefarm.qa.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PersonalDetails {

	public static ArrayList<String> getJohnDetails(){
		ArrayList<String> details = new ArrayList<>();
		details.add("John");
		details.add("Henry");
		details.add("Doe");
		details.add("Sr");
		details.add("8788 Leffferts Blvd");
		details.add("2B");
		details.add("Richmond Hill");
		details.add("11418");
		details.add("10/11/2000");
		details.add(getDate());
		return details;
	}
	
	public static Object[] getJohnDetailsObj(){
		Object[] details = new Object[10];
		details[0] = "John";
		details[1] = "Henry";
		details[2] = "Doe";
		details[3] = "Sr";
		details[4] = "8788 Leffferts Blvd";
		details[5] = "2B";
		details[6] = "Richmond Hill";
		details[7] = "11418";
		details[8] = "10/11/2000";
		details[9] = getDate();
		return details;
	}
	
	public static ArrayList<String> getSimonDetails(){
		ArrayList<String> details = new ArrayList<>();
		details.add("Collins");
		details.add("Henry");
		details.add("Simon");
		details.add("Jr");
		details.add("1064 Ethaca St");
		details.add("6B");
		details.add("Elmhurst");
		details.add("11011");
		details.add("13/11/1955");
		details.add(getDate());
		return details;
	}
	
	public static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		return dateFormat.format(new Date());
	}
}
