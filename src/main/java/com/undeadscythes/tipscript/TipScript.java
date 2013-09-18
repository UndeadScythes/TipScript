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
    private static final Handler CONSOLE_HANDLER;

    static {
        CONSOLE_HANDLER = new ConsoleHandler();
        CONSOLE_HANDLER.setFormatter(new TipFormatter());
    }

    private BufferedWriter file;
    private boolean isOpen;
    private final String prompt;
    private final Logger console;

    /**
     *
     * @param logger
     * @param prompt
     */
    public TipScript(final Logger logger, final String prompt) {
        console = logger;
        for (final Handler handler : console.getHandlers()) {
            console.removeHandler(handler);
        }
        console.addHandler(CONSOLE_HANDLER);
        console.setUseParentHandlers(false);
        this.prompt = prompt;
    }

    /**
     *
     * @param path
     * @return True if the file opened successfully
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
     *
     * @param string
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
     *
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
     *
     */
    public void println() {
        println("");
    }

    /**
     *
     * @param string
     */
    public void println(final String string) {
        print(string + "\n");
    }

    /**
     *
     */
    public void print() {
        print("");
    }

    /**
     *
     * @param line
     */
    public void print(final String line) {
        console.log(TipLevel.OUTPUT, prompt + line);
    }
}
