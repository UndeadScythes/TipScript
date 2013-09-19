package tipscripttest;

import com.undeadscythes.tipscript.*;
import java.io.*;
import static java.util.logging.Logger.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class TipScriptTest extends Assert {
    private TipScript tipScript;

    @Before
    public void init() {
        tipScript = new TipScript(getLogger("test"), "tip>");
    }

    @Test
    public void testFileCrash() throws IOException {
        assertFalse("open bad file", tipScript.openFile(""));
    }

    @Test
    public void testFileOpen() throws IOException {
        tipScript.openFile("test");
        tipScript.printf("test");
        tipScript.closeFile();
        final File file = new File("test");
        assertTrue("file creation", file.exists());
        assertTrue("file deletion", file.delete());
    }
}
