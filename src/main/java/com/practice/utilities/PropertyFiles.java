package com.practice.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFiles {
	
	private Properties pt;

	public PropertyFiles() throws IOException {
		pt=new Properties();
		
		try {
			FileInputStream files=new FileInputStream("src\\\\main\\\\resources\\\\config.properties");
			pt.load(files);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String readfromProperties(String key) {
		return pt.getProperty( key);
	}
	
	

}
