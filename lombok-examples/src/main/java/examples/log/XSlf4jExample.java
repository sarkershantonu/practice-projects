package examples.log;

import lombok.extern.slf4j.XSlf4j;

/**
 * Created by shantonu on 5/31/16.
 */
@XSlf4j(topic = "XSlf4j topic")
public class XSlf4jExample {
    public static void log() {

        log.debug("This is debug logging using "+ log.getClass());
        log.info("This is info logging using "+ log.getClass());
        log.trace("This is trace logging using "+ log.getClass());
        log.error("This is error logging using "+ log.getClass());
        log.warn("This is warn logging using "+ log.getClass());

    }
}
