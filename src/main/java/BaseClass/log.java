package BaseClass;

import org.apache.log4j.Logger;

public class log {

	// Initialize log4j logs
	static Logger log = Logger.getLogger(log.class.getName());//

	// https://www.tutorialspoint.com/log4j/log4j_logging_methods.htm

	// syntax: Logger.getLogger(class_name.class.getName())
	// Parameters: getLogger method accepts a single parameter name which is the
	// String representing name for the logger.
	// This should be a dot-separated name and should normally be based on the
	// package name or class name of the subsystem

	/*
	 * When you call getLogger(String) it looks for a defined logger with that
	 * name. Try just doing Logger.getLogger(Experience.class), that should get
	 * you the logger for Experience
	 */

	// The getLogger() method of a Logger class used find or create a logger.
	// If there is a logger exists with the passed name then the method will
	// return that logger
	// else method will create a new logger with that name and return it.

	// This is to print log for the beginning of the test case, as we usually
	// run so many test cases as a test suite

	public static void startTestCase(String sTestCaseName) {

		log.info("****************************************************************************************");

		log.info("****************************************************************************************");

		log.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");

		log.info("****************************************************************************************");

		log.info("****************************************************************************************");

	}

	// This is to print log for the ending of the test case

	public static void endTestCase(String sTestCaseName) {

		log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");

	}

	public static void info(String message) {

		log.info(message);

	}

	public static void warn(String message) {

		log.warn(message);

	}

	public static void error(String message) {

		log.error(message);

	}

	public static void fatal(String message) {

		log.fatal(message);

	}

	public static void debug(String message) {

		log.debug(message);

	}

}
