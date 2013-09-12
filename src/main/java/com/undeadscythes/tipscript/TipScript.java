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
    private static final Handler HANDLER;

    static {
        HANDLER = new StreamHandler();
        HANDLER.setFormatter(new TipFormatter());
    }

    private BufferedWriter file;
    private boolean isOpen;
    private final String prompt;
    private final Logger logger;

    /**
     *
     * @param logger
     * @param prompt
     */
    public TipScript(final Logger logger, final String prompt) {
        this.logger = logger;
        this.logger.addHandler(HANDLER);
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
            logger.log(TipLevel.WARNING, "I/O Exception.");
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
            logger.log(TipLevel.WARNING, "I/O Exception.");
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
        print(string + Character.LINE_SEPARATOR);
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
        logger.log(TipLevel.OUTPUT, prompt + line);
    }
}
