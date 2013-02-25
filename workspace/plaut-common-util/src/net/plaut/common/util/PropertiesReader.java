package net.plaut.common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	private Properties prop;
	
	public PropertiesReader(String fileNamePath) {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(fileNamePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String propertyKey){
		return prop.getProperty(propertyKey);
	}

}
