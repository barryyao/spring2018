import org.junit.Test;
import static org.junit.Assert.*;

/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        return a == b;
    }

    @Test
    public void testIsSameNumber() {
        assertTrue(isSameNumber(1, 1));
        assertFalse(isSameNumber(1, 2));
        assertTrue(isSameNumber(127, 127));
        assertFalse(isSameNumber(128, 128));
        assertFalse(isSameNumber(129, 129));
    }
}
