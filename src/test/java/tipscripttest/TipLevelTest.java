package tipscripttest;

import com.undeadscythes.tipscript.*;
import java.util.logging.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class TipLevelTest extends Assert {
    @Test
    public void testParse() {
        assertEquals(TipLevel.OUTPUT, Level.parse("OUTPUT"));
        assertEquals(TipLevel.OUTPUT, Level.parse(String.valueOf(Level.INFO.intValue() + 1)));
    }
}
