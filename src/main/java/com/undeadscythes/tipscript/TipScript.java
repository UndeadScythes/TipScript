package com.undeadscythes.tipscript;

import java.io.*;
import java.util.logging.*;

/**
 * TipScript provides quick and easy access to professional looking command line
 * and file outputting tools.
 *
 * @author UndeadScythes
 */
public class TipScript {
    private static final Handler CONSOLE_HANDLER = new ConsoleHandler();;

    static {
        CONSOLE_HANDLER.setFormatter(new TipFormatter());
    }

    private BufferedWriter file;
    private boolean isOpen;
    private final String prefix;
    private final Logger console;

    /**
     * Provide a {@link Logger} to use as a standard output and a prefix to
     * display before each line of output.
     */
    public TipScript(final Logger logger, final String prefix) {
        console = logger;
        for (final Handler handler : console.getHandlers()) {
            console.removeHandler(handler);
        }
        console.addHandler(CONSOLE_HANDLER);
        console.setUseParentHandlers(false);
        this.prefix = prefix;
    }

    /**
     * Open a {@link File} at the given path to use as an output source. Output
     * can be written to this file using {@link #printf printf()}.
     *
     * @return False if the file could not be opened.
     */
    public boolean openFile(final String path) {
        isOpen = true;
        try {
            file = new BufferedWriter(new FileWriter(path));
        } catch (IOException ex) {
            isOpen = false;
        }
        return isOpen;
    }

    /**
     * Write to the {@link File} opened with
     * {@link #openFile(String) openFile(String)}. If no {@link File} is open
     * this method will send the output to the {@link Logger} provided on
     * construction.
     */
    public void printf(final String string) {
        if (!isOpen) {
            println(string);
            return;
        }
        try {
            file.write(string);
            file.newLine();
        } catch (IOException ex) {
            console.log(TipLevel.WARNING, "I/O Exception.");
        }
    }

    /**
     * Close the {@link File} that was opened with
     * {@link #openFile(String) openFile(String)}.
     */
    public void closeFile() {
        if (!isOpen) {return;}
        try {
            file.close();
            isOpen = false;
        } catch (IOException ex) {
            console.log(TipLevel.WARNING, "I/O Exception.");
        }
    }

    /**
     * Output a new line.
     */
    public void println() {
        println("");
    }

    /**
     * Output a {@link String} followed by a new line.
     */
    public void println(final String string) {
        print(string + "\n");
    }

    /**
     * Output only the provided prefix with no new line.
     */
    public void print() {
        print("");
    }

    /**
     * Output a {@link String} with no new line.
     */
    public void print(final String line) {
        console.log(TipLevel.OUTPUT, prefix + line);
    }
}
