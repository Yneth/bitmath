package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplyTest {

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyBigArguments() throws Exception {
        BitMath.multiply(1L << 62, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyBigArguments1() throws Exception {
        BitMath.multiply(Long.MAX_VALUE, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyBigArguments2() throws Exception {
        assertEquals(-Long.MAX_VALUE, BitMath.multiply(2, -Long.MAX_VALUE));
    }

    @Test
    public void testMultiply() throws Exception {
        assertEquals(791878820976L, BitMath.multiply(231312, 3423423));
        assertEquals(321312, BitMath.multiply(160656, 2));
    }

    @Test
    public void testMultiplyCornerCases() throws Exception {
        assertEquals(0, BitMath.multiply(32112, 0));
        assertEquals(0, BitMath.multiply(0, 432423));

        assertEquals(0, BitMath.multiply(-215849, 0));
        assertEquals(0, BitMath.multiply(0, -439228));

        assertEquals(0, BitMath.multiply(-215849, 0));
        assertEquals(0, BitMath.multiply(0, -439228));

        assertEquals(1, BitMath.multiply(1, 1));

        assertEquals(Long.MAX_VALUE, BitMath.multiply(1, Long.MAX_VALUE));
        assertEquals(Long.MAX_VALUE, BitMath.multiply(Long.MAX_VALUE, 1));


        assertEquals(-Long.MAX_VALUE, BitMath.multiply(Long.MAX_VALUE, -1));
    }
}
