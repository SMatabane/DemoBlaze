package com.practice.utilities;

import org.apache.log4j.Logger;



public class Logs4j {
	
	// Initialize Log4j logs
		public static Logger Log = Logger.getLogger(Logs4j.class.getName());
		
  /**
   * Method for logging name of test once tests starts
   * @param name
   */
	public static void startTestCase(String name){		  
	Log.info("====================================="+name+" TEST STARTED=========================================");
	}
	
	/**
	   * Method for logging name of test once tests ends
	   * @param name
	   */
		public static void endTestCase(String name){
		Log.info("====================================="+name+" TEST ENDED=========================================");
		 }
		
		/**
		   * Method for logging information message 
		   * @param message
		   */
		public static void info(String message) {

			Log.info(message);

			}
		/**
		   * Method for logging warnings message 
		   * @param message
		   */
	 public static void warn(String message) {

	    Log.warn(message);

		}
	 /**
	   * Method for logging error message 
	   * @param message
	   */
	 public static void error(String message) {

	    Log.error(message);

		}
	 
	 /**
	   * Method for logging debug message 
	   * @param message
	   */
		 public static void debug(String message) {

		    Log.debug(message);

			}


}
