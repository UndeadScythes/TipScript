package tipscripttest;

import com.undeadscythes.tipscript.*;
import java.io.*;
import java.util.logging.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class TipScriptTest extends Assert {
    private TipScript tipScript;

    @Before
    public void init() {
        tipScript = new TipScript(Logger.getLogger("test"), "tip>");
    }

    @Test
    public void testFileCrash() throws IOException {
        assertFalse(tipScript.openFile(""));
    }

    @Test
    public void testFileOpen() throws IOException {
        tipScript.openFile("test");
        tipScript.printf("test");
        tipScript.closeFile();
        final File file = new File("test");
        assertTrue(file.exists());
        assertTrue(file.delete());
    }
}
