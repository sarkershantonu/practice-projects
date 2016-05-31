package examples.log;

import lombok.extern.log4j.Log4j;

/**
 * Created by shantonu on 5/31/16.
 */

@Log4j(topic = "log4j topic")
public class Log4jExample {
    public static void log() {
        log.debug("This is debug logging using "+ log.getClass());
        log.info("This is info logging using "+ log.getClass());
        log.trace("This is trace logging using "+ log.getClass());
        log.error("This is error logging using "+ log.getClass());
        log.fatal("This is fatal logging using "+ log.getClass());
        log.warn("This is warn logging using "+ log.getClass());


    }
}
