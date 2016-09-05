package org.automation;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * Created by shantonu on 9/6/16.
 */
public class LogFilter implements Filter {
    public LogFilter(String filter) {
        this.filterMessage = filter;
    }
    private LogFilter(){}
    private String filterMessage = null;

    public boolean isLoggable(LogRecord record) {
        if(record==null)
            return false;
        String message = record.getMessage();
        if(message.contains(filterMessage))
            return true;
        return false;
    }
}
