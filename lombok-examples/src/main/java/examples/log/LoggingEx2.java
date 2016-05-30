package examples.log;

import lombok.extern.java.Log;

import java.util.logging.Level;

/**
 * Created by shantonu on 5/31/16.
 */
@Log
class LoggingEx2 {
    private void log() {
        log.info("Logging from java.util.logging.Logger=> using  @Log");
        log.log(Level.WARNING, "warning");

    }
}
