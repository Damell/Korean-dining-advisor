package kr.ac.ajou.dsd.kda.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	private Properties properties;
	
	public Config(String propertiesFile) throws FileNotFoundException, IOException {
		this.properties = new Properties();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFile);
		if (inputStream != null) {
			properties.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propertiesFile + "' not found in the classpath");
		}
	}
	
	public String getProperty(String key){
		return properties.getProperty(key);
	}
	
}
