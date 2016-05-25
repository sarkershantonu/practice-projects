package examples;


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
@Slf4j
public class LoggingEx {
    public void slf4j() {

    }
    public static void main(String... args) {

    }
}

@Log
class LoggingEx2 {
    private void log() {
        log.info("Logging from java.util.logging.Logger=> using  @Log");
        log.log(Level.WARNING, "warning");

    }
}

@CommonsLog
class LoggingEx3 {
    public void commonsLog() {


    }
}

@Log4j
class LoggingEx4 {
    public void log4j() {


    }
}

@Log4j2
class LoggingEx5 {
    public void log4j2() {

    }
}

@XSlf4j
class LoggingEx1 {
    public void xslf4j() {


    }
}