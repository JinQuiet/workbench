package com.jinquiet;

import java.io.Console;
import java.sql.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Workbench
 *
 */
public class Workbench {
    private final static Logger logger = LoggerWrapper.getLogger(Workbench.class.getName());

    public static void main(String[] args) throws InterruptedException {
        logger.setLevel(Level.WARNING);
        
        logger.warning("read");
        
        Test<String> t = new Test<String>();
        t.run("Good!");

        //final static int i = 1;
    }
}


class Test<T> {
    private final static Logger logger = LoggerWrapper.getLogger(Test.class.getName());

    public boolean run (T t) {
        if (t instanceof String) {
            logger.info("This is definetely a string :: " + t.toString());
            return true;
        } else {
            logger.info("Not a String :: " + t.toString());            
            return false;
        }
    }
}

class LoggerWrapper {

    private static Logger logger;

    private final static String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";
    private final static ConsoleHandler consoleHandler = getConsoleHandler(format);

    static {
      

    }

    private static ConsoleHandler getConsoleHandler(String loggerFormat) {
        //
        ConsoleHandler consoleHandler = new ConsoleHandler();
        
        consoleHandler.setFormatter(new SimpleFormatter() {

            @Override
            public synchronized String format(LogRecord lr) {
                return String.format(loggerFormat,
                        new Date(lr.getMillis()),
                        lr.getLevel().getLocalizedName(),
                        lr.getMessage()
                );
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
}

/*abstract

 private static Logger LOGGER = null;

  static {
      Logger mainLogger = Logger.getLogger("com.logicbig");
      mainLogger.setUseParentHandlers(false);
      ConsoleHandler handler = new ConsoleHandler();
      handler.setFormatter(new SimpleFormatter() {
          private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

          @Override
          public synchronized String format(LogRecord lr) {
              return String.format(format,
                      new Date(lr.getMillis()),
                      lr.getLevel().getLocalizedName(),
                      lr.getMessage()
              );
          }
      });
      mainLogger.addHandler(handler);
      LOGGER = Logger.getLogger(MyClass3.class.getName());
  }

  public static void main(String[] args) {
      System.out.println("-- main method starts --");
      LOGGER.info("in MyClass3");
      LOGGER.warning("a test warning");
  }

*/