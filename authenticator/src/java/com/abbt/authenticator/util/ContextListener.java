/*
 * Created on Apr 23, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.abbt.authenticator.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.LogLog;

/**
 * @author Ha9h2my
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class ContextListener implements ServletContextListener {

	/**
	 * The Log4j initialisation is done in this method.
	 */
	public void contextInitialized(ServletContextEvent event) {

		System.out.println("Initialising log 4j");
		LogLog.setInternalDebugging(true);
		//turn log4j's internal logging to see initialization of properties
		// file
		String fileLocation = "log4j.properties";
		InputStream unbuffered = getClass().getResourceAsStream(fileLocation);
		Properties props = new Properties();

		try {

			props.load(unbuffered);

		} catch (IOException e) {

			System.out.println("Error loading initialising log4j.");
			e.printStackTrace();
		}

		PropertyConfigurator.configure(props);

	}

	/**
	 *  
	 */
	public void contextDestroyed(ServletContextEvent event) {

	}

}