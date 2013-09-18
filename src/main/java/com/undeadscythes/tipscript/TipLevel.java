package com.undeadscythes.tipscript;

import java.util.logging.*;

/**
 * @author UndeadScythes
 */
public final class TipLevel extends Level {
    /**
     * Handled by a {@link TipFormatter} to look like {@link System#out}.
     */
    public static final TipLevel OUTPUT;

    private static final long serialVersionUID = 1L;

    static {
        OUTPUT = new TipLevel("OUTPUT", Level.INFO.intValue() + 1);
    }

    private TipLevel(final String name, final int value) {
        super(name, value);
    }
}
