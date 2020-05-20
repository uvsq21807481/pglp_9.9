package uvsq21807481.Shape;

import org.junit.Test;
import static org.junit.Assert.*;

public class CircleTest {

    @Test
    public void testCircle() {
        Circle c = new Circle("c", 0, 0, 2.5);
        assertEquals(2.5, c.radius, 0);
    }
}
