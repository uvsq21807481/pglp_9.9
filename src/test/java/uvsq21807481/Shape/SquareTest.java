package uvsq21807481.Shape;

import org.junit.Test;
import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void testSquareSide() {
        Square s = new Square("s", 2, 2, 4);
        assertEquals(4, s.side, 0);
    }
}
