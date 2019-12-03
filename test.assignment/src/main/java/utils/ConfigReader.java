package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties properties;
	private final String propertyFilePath= "configs//Application.properties";

	public ConfigReader(){
		BufferedReader reader;
		try	{
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}catch(FileNotFoundException e)	{
			e.printStackTrace();
			throw new RuntimeException("Application.properties not found at " + propertyFilePath);
		}
	}

	public String getURL(){
		String driverPath = properties.getProperty("url");
		if(driverPath!= null) 
			return driverPath;
		else 
			throw new RuntimeException("URL not specified in the Configuration.properties file."); 
	}
}
