package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemainderTest {

    @Test
    public void testRemainder() {
        assertEquals(7, BitMath.remainder(21, 14));
    }

    @Test
    public void testNegativeDivisor() {
        assertEquals(7, BitMath.remainder(21, -14));
        assertEquals(0, BitMath.remainder(321321, -321));
        assertEquals(42, BitMath.remainder(433225, -211));
    }
}
