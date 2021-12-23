package com.jinquiet.logger;

import java.sql.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerWrapper {

    private static Logger logger;

    private final static String logFormat = "[%1$tF %1$tT] [%2$-7s] %3$s %n";
    private final static ConsoleHandler consoleHandler = getConsoleHandler(logFormat);

    private static ConsoleHandler getConsoleHandler(String loggerFormat) {

        ConsoleHandler consoleHandler = new ConsoleHandler();

        consoleHandler.setFormatter(new SimpleFormatter() {

            @Override
            public synchronized String format(LogRecord logRecord) {
                return String.format(loggerFormat,
                        new Date(logRecord.getMillis()),
                        logRecord.getLevel().getLocalizedName(),
                        logRecord.getMessage());
            }
        });
        return consoleHandler;
    }

    public static Logger getLogger(String className) {
        logger = Logger.getLogger(className);
        logger.setUseParentHandlers(false);
        logger.addHandler(consoleHandler);
        return logger;
    }

    public static <T> Logger getLogger(Class<T> clazz) {
        return getLogger(clazz.getName());
    }    
}
