package examples.log;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;

/**
 * Created by shantonu on 5/31/16.
 * this shows we can have multiple logging implementation application wide, just based on dependency & associated configuration , we can change implementation
 * Priority in case of duplicate => first one over the last
 */

@Slf4j
@XSlf4j
@Log4j
@Log4j2
@CommonsLog
public class AllLoggers {
    /**
     * these are common log function supported by this 5 loggers.
     */
    public static void log() {
        log.debug("This is debug logging using "+ log.getClass());
        log.info("This is info logging using "+ log.getClass());
        log.trace("This is trace logging using "+ log.getClass());
        log.error("This is error logging using "+ log.getClass());
        log.warn("This is warn logging using "+ log.getClass());
    }
}
