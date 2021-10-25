package com.statefarm.qa.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\mdnas\\OneDrive\\Documents\\Enthrall.IT\\Projects\\June2021_Base\\config.properties";
		File file = new File(path);
		FileReader fileReader = new FileReader(file);
		Properties properties = new Properties();
		properties.load(fileReader);
		System.out.println(properties.get("username"));
	}
}
