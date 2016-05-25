package examples;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.java.Log;
import lombok.extern.log4j.*;
import lombok.extern.slf4j.*;

import java.util.logging.Level;

/**
 * Created by shantonu on 5/25/16.
 */
@Slf4j
public class LoggingEx {

    public static void pr() {

        //log.info("Logging from java.util.logging.Logger=> using  @Log");
        //log.log(Level.WARNING, "warning");
    }
}

class LoggingEx2 {
    private void pr() {


    }
}
@CommonsLog
class LoggingEx3 {
}
@Log4j

class LoggingEx4 {
}
@Log4j2
class LoggingEx5 {
}
@XSlf4j
class LoggingEx1 {
}