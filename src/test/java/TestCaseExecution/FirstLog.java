package TestCaseExecution;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class FirstLog {

		static Logger log = Logger.getLogger(FirstLog.class);
		//logger is a class
		//getlogger is a static method
		//syntaxt is Logger.getLogger(class_name.class)
		//here Logger is used for logging operations
		//i.e Logger is the class used to log application messages in java
		//Individual classes can use this logger to write messages to the configured log files
		
		public static void main(String[] args) {
			//PropertiesConfigurator is used to configure logger from the properties file
					PropertyConfigurator.configure("C:\\Users\\neha\\workspace\\POMFramework\\Logs\\Log4J.properties");

					//log the message to file
					log.info("This is an info message");
					log.info("This is an info message");
					log.info("This is an info message");
					log.info("This is an info message");
					
					
					System.out.println("Test Cases Executed");
		}
	}