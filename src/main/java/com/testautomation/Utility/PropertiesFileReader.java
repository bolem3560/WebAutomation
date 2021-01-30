package com.testautomation.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	/**
	 * Data reading from Properties file
	 * 
	 * @return
	 * @throws IOException
	 */
	public Properties getProperty() throws IOException {

		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//browser-config.properties"));
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return properties;
	}

}
