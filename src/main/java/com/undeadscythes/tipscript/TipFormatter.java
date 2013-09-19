package com.undeadscythes.tipscript;

import java.util.logging.*;

/**
 * This {@link Formatter} checks for a log level of
 * {@link TipLevel#OUTPUT OUTPUT} and will remove all usual {@link Logger}
 * output text and return the message alone.
 *
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
