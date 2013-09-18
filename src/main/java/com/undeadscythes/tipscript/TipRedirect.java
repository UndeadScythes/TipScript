package com.undeadscythes.tipscript;

import static java.util.logging.Logger.*;

/**
 * @author UndeadScythes
 */
public class TipRedirect extends TipScript {
    private final StringBuilder output;

    /**
     *
     * @param output
     */
    public TipRedirect(final StringBuilder output) {
        super(getLogger(TipRedirect.class.getName()), "");
        this.output = output;
    }

    /**
     *
     */
    public TipRedirect() {
        super(getLogger(TipRedirect.class.getName()), "");
        output = new StringBuilder("");
    }

    @Override
    public void print(final String string) {
        output.append(string);
    }

    /**
     *
     * @return Output that was delivered to this {@link TipScript}
     */
    public String getOutput() {
        return output.toString();
    }
}
