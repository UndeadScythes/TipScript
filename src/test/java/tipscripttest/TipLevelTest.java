package tipscripttest;

import com.undeadscythes.tipscript.*;
import static java.lang.String.*;
import java.util.logging.*;
import static java.util.logging.Level.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class TipLevelTest extends Assert {
    @Test
    public void testParse() {
        assertEquals("name", TipLevel.OUTPUT, parse("OUTPUT"));
        assertEquals("value", TipLevel.OUTPUT, parse(valueOf(Level.INFO.intValue() + 1)));
    }
}
