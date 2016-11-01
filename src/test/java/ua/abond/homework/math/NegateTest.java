package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NegateTest {

    @Test
    public void testNegate() {
        int value = 321312312;
        assertEquals(-value, BitMath.negate(value));
        value = -23128321;
        assertEquals(-value, BitMath.negate(value));
    }

    @Test
    public void testNegateCornerCases() {
        assertEquals(Integer.MIN_VALUE, BitMath.negate(Integer.MIN_VALUE));
        assertEquals(0, BitMath.negate(0));
        assertEquals(-Integer.MAX_VALUE, BitMath.negate(Integer.MAX_VALUE));
    }
}
