package week3.day2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	private static Properties properties;
	
	static {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(new File("src/main/resources/config.properties")));			
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Unable to found \"src/main/resources/config.properties\" file in mentioned loaction.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getUserName() {		
		return properties.getProperty("serivce.now.username");
	}

	public static String getPassword() {
		return properties.getProperty("service.now.password");
	}

	public static String getClientId() {		
		return properties.getProperty("service.now.client.id");
	}

	public static String getClientSecret() {		
		return properties.getProperty("service.now.client.secret");
	}

}