package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbsTest {

    @Test
    public void testLongAbs() {
        assertEquals(321321321312L, BitMath.abs(321321321312L));
        assertEquals(321321321312L, BitMath.abs(-321321321312L));
    }

    @Test
    public void testLongAbsCornerCases() {
        assertEquals(0, BitMath.abs(0));
        assertEquals(Long.MIN_VALUE, BitMath.abs(Long.MIN_VALUE));
        assertEquals(Long.MAX_VALUE, BitMath.abs(Long.MAX_VALUE));
    }

    @Test
    public void testIntAbs() {
        assertEquals(3, BitMath.abs(3));
        assertEquals(3, BitMath.abs(-3));
    }

    @Test
    public void testIntAbsCornerCases() {
        assertEquals(0, BitMath.abs(0));
        assertEquals(Integer.MIN_VALUE, BitMath.abs(Integer.MIN_VALUE));
        assertEquals(Integer.MAX_VALUE, BitMath.abs(Integer.MAX_VALUE));
    }
}
