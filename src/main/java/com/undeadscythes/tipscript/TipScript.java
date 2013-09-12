package com.undeadscythes.tipscript;

import java.io.*;

/**
 * TipScript provides quick and easy access to professional looking command line
 * and file outputting tools.
 *
 * @author UndeadScythes
 */
public class TipScript {
    private BufferedWriter file;
    private boolean isOpen;
    private final PrintStream outputStream;
    private final String prompt;

    /**
     *
     * @param outputStream
     * @param prompt
     */
    public TipScript(final PrintStream outputStream, final String prompt) {
        this.outputStream = outputStream;
        this.prompt = prompt;
    }

    /**
     *
     * @param path
     * @throws IOException
     */
    public void openFile(final String path) throws IOException {
        file = new BufferedWriter(new FileWriter(path));
        isOpen = true;
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
            outputStream.println(prompt + "I/O Exception.");
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
            outputStream.println(prompt + "I/O Exception.");
        }
    }

    /**
     *
     */
    public void println() {println("");}

    /**
     *
     * @param string
     */
    public void println(final String string) {
        outputStream.println(prompt + string);
    }

    /**
     *
     */
    public void print() {print("");}

    /**
     *
     * @param line
     */
    public void print(final String line) {
        outputStream.print(prompt + line);
    }
}
