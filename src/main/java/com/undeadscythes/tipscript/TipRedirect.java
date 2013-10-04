package com.undeadscythes.tipscript;

import java.util.logging.*;

/**
 * {@link TipRedirect} allows all usual output to be redirected to another
 * location.
 *
 * @author UndeadScythes
 */
public class TipRedirect extends TipScript {
    private final StringBuilder output;

    /**
     * Redirect output to the given {@link StringBuilder}.
     */
    public TipRedirect(final StringBuilder output) {
        super(Logger.getLogger(TipRedirect.class.getName()), "");
        this.output = output;
    }

    /**
     * Store all output and retrieve it later using
     * {@link #getOutput getOutput()}.
     */
    public TipRedirect() {
        this(new StringBuilder(""));
    }

    @Override
    public void print(final String string) {
        output.append(string);
    }

    /**
     * Get the output that was delivered to this {@link TipScript} and clear the
     * buffer.
     */
    public String getOutput() {
        final String result = output.toString();
        output.delete(0, output.length());
        return result;
    }

    /**
     * Flush the contents of the string buffer.
     */
    public void flush() {
        output.delete(0, output.length());
    }
}
