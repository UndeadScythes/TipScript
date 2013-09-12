package com.undeadscythes.tipscript;

import java.util.logging.*;

/**
 * @author UndeadScythes
 */
public class TipFormatter extends Formatter {
    @Override
    public String format(final LogRecord record) {
        String formattedString;
        if (record.getLevel().equals(TipLevel.OUTPUT)) {
            formattedString = formatMessage(record);
        } else {
            formattedString = new SimpleFormatter().format(record);
        }
        return formattedString;
    }
}
