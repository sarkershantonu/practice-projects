package examples.log;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;

import java.util.logging.Level;
/**
 * Created by shantonu on 5/25/16.
 */

@Slf4j(topic = "Slf4j topic")
public class Slf4jExample {
    public static void log() {
        log.debug("This is debug logging using "+ log.getClass());
        log.info("This is info logging using "+ log.getClass());
        log.trace("This is trace logging using "+ log.getClass());
        log.error("This is error logging using "+ log.getClass());

        log.warn("This is warn logging using "+ log.getClass());

    }

}










