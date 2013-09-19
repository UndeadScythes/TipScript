package com.undeadscythes.tipscript;

import static java.util.logging.Logger.*;

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
        super(getLogger(TipRedirect.class.getName()), "");
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
     * Get the output that was delivered to this {@link TipScript}.
     */
    public String getOutput() {
        return output.toString();
    }
}
