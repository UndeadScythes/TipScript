package tipscripttest;

import com.undeadscythes.tipscript.*;
import java.util.logging.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class TipFormatterTest extends Assert {
    @Test
    public void testFormat() {
        final TipFormatter formatter = new TipFormatter();
        assertEquals("output", "test", formatter.format(new LogRecord(TipLevel.OUTPUT, "test")));
        assertTrue("info", formatter.format(new LogRecord(TipLevel.INFO, "test")).replace("\r", "").replace("\n", "").endsWith("INFO: test"));
    }
}
