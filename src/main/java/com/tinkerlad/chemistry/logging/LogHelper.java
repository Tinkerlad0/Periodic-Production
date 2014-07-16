package com.tinkerlad.chemistry.logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public class LogHelper {

	public static Logger logger;

	@Deprecated
	public static void log(Level level, String message) {logger.log(level, message);}

	public static void info(String message) {log(Level.INFO, message);}

	public static void error(String message) {log(Level.ERROR, message);}
}
