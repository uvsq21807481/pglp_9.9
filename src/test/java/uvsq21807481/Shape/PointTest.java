package uvsq21807481.Shape;

import org.junit.Test;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void testPointX() {
        Point p = new Point(0, 0);
        assertEquals(0, p.getX(), 0);
    }

    @Test
    public void testPointY() {
        Point p = new Point(0,0);
        assertEquals(0, p.getY(), 0);
    }

    @Test
    public void testMoveX() {
        Point p = new Point(0, 0);
        p.movePoint(1,1);
        assertEquals(1, p.getX(), 0);
    }

    @Test
    public void testMoveY() {
        Point p = new Point(0, 0);
        p.movePoint(1,1);
        assertEquals(1, p.getY(), 0);
    }
}
