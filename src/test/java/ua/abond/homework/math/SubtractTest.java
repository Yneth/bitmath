package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubtractTest {

    @Test
    public void testSubtract() {
        assertEquals(27165623, BitMath.subtract(54331246, 27165623));
        assertEquals(0, BitMath.subtract(43287, BitMath.add(14429, BitMath.add(14429, 14429))));
    }

    @Test
    public void testCornerCasesOfSubtract() {
        assertEquals(0, BitMath.subtract(Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertEquals(Integer.MIN_VALUE, BitMath.subtract(0, Integer.MIN_VALUE));
        assertEquals(Integer.MAX_VALUE, BitMath.subtract(Integer.MAX_VALUE, 0));

        assertEquals(-1, BitMath.subtract(Integer.MAX_VALUE, Integer.MIN_VALUE));

        assertEquals(0, BitMath.add(0, 0));

        assertEquals(Integer.MIN_VALUE, BitMath.add(Integer.MAX_VALUE, 1));
        assertEquals(Integer.MAX_VALUE, BitMath.add(Integer.MIN_VALUE, -1));
    }
}
