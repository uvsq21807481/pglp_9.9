package uvsq21807481.Shape;

import org.junit.Test;
import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void testRectangleLength() {
        Rectangle r = new Rectangle("r", 4, 4, 8, 8);
        assertEquals(8, r.length, 0);
    }

    @Test
    public void testRectangleWidth() {
        Rectangle r = new Rectangle("r", 4, 4, 8, 8);
        assertEquals(8, r.width, 0);
    }
}
