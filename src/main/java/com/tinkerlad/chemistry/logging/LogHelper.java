package com.tinkerlad.chemistry.logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public class LogHelper {

	public static Logger logger;

	public static void log(Level level, String message) {

		logger.log(level, message);
	}
}
