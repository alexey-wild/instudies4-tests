package com.instudies.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

	public static String getProperty(String property) {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("src/main/resources/config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props.getProperty(property);
	}
}
