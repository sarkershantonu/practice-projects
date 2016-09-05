package org.automation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {
    private static Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String... args) {
        log.info("Log from initial");
        log.warn("Warn logging");
        log.debug("debug logging");
        log.error("Error logging");
        log.trace("Trace logging");
        System.out.println("This is SL4J-Log4J example, you should expect logs in /logs/logging.log & Commandline log");
    }

}
