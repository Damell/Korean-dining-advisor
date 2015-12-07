package kr.ac.ajou.dsd.kda.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * class to read properties from a given property file
 * @author Torben Tietze <torben.tietze@googlemail.com>
 *
 */
public class Config {
	private Properties properties;
	private String propertiesFile;
	
	public Config(String propertiesFile){
		this.propertiesFile = propertiesFile;
		this.properties = new Properties();
		
		try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFile)){
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key){
		return properties.getProperty(key);
	}
}
