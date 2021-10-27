package com.statefarm.qa.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	private static ReadProperties instanceProperties;
	private static Properties properties;
	
	private static String username;
	private static String password;
	
	private final static String configFilePath = "configuration\\config.properties";
	
	private ReadProperties() {
	}
	
	public static ReadProperties instanceOFProp() {
		if (instanceProperties == null) {
			instanceProperties = new ReadProperties();
			instanceProperties.loadProperties();
		}
		return instanceProperties;
	}
	
	private void loadProperties() {
		BufferedReader bufferedReader;
		properties = new Properties();
		try {
			bufferedReader = new BufferedReader(new FileReader(configFilePath));
			properties.load(bufferedReader);
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("File Not Found on the given location : " + new File(configFilePath).getAbsolutePath());
		}
		username = properties.getProperty("username");
		password = properties.getProperty("password");
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
