package com.xotiv.sitenna.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String readThedataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\sitenna_landlord.properties");
		Properties prob = new Properties();
		prob.load(fis);
		String value = prob.getProperty(key);
		return value;
	}

}
