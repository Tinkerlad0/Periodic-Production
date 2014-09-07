package com.tinkerlad.chemistry.logging;

import com.tinkerlad.chemistry.Chemistry;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogFile {

    static Logger logger;

    static FileHandler fileHandler;

    public static void init(File parentDir) {
        logger = Logger.getLogger(Chemistry.MODID + ":FILE");
        logger.setUseParentHandlers(false);
        try {
            fileHandler = new FileHandler(parentDir.getAbsolutePath() + "/TNKChem.log");
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.info("Log File Initialised");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warning(String message) {
        logger.warning(message);
    }
}
