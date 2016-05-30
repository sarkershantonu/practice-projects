package examples.log;

import lombok.extern.java.Log;

import java.util.logging.Level;


/**
 * Created by shantonu on 5/31/16.
 */
@Log
public class JavaLogApiExample {
    public static void log() {

        //log.setLevel(Level.FINEST);
        log.fine("This is fine logging using "+ log.getClass());
        log.info("This is info logging using "+ log.getClass());
        log.finer("This is finer logging using "+ log.getClass());
        log.finest("This is finest logging using "+ log.getClass());
        log.config("This is config logging using "+ log.getClass());
        log.severe("This is severe logging using "+ log.getClass());
        log.warning("This is warning logging using "+ log.getClass());
    }
}
