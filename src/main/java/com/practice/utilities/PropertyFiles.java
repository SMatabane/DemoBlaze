package com.practice.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFiles {
	
	private Properties pt;

	public PropertyFiles(String file) throws IOException {
		pt=new Properties();
		
		try {
			FileInputStream files=new FileInputStream(file);
			pt.load(files);
			file.getClass();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String readfromProperties(String key) {
		return pt.getProperty( key);
	}
	
	

}
