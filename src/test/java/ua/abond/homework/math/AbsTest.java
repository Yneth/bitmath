package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbsTest {

    @Test
    public void testLongAbs() throws Exception {
        assertEquals(321321321312L, BitMath.abs(321321321312L));
        assertEquals(321321321312L, BitMath.abs(-321321321312L));
    }

    @Test
    public void testLongAbsCornerCases() throws Exception {
        assertEquals(0, BitMath.abs(0));
        assertEquals(Long.MIN_VALUE, BitMath.abs(Long.MIN_VALUE));
        assertEquals(Long.MAX_VALUE, BitMath.abs(Long.MAX_VALUE));
    }

    @Test
    public void testIntAbs() throws Exception {
        assertEquals(3, BitMath.abs(3));
        assertEquals(3, BitMath.abs(-3));
        assertEquals(312, BitMath.abs(-312));
        assertEquals(432432423, BitMath.abs(-432432423));
        assertEquals(21312321, BitMath.abs(-21312321));
        assertEquals(37489584, BitMath.abs(-37489584));
        assertEquals(85857738, BitMath.abs(-85857738));
        assertEquals(35876939, BitMath.abs(-35876939));
    }

    @Test
    public void testIntAbsCornerCases() throws Exception {
        assertEquals(0, BitMath.abs(0));
        assertEquals(Integer.MIN_VALUE, BitMath.abs(Integer.MIN_VALUE));
        assertEquals(Integer.MAX_VALUE, BitMath.abs(Integer.MAX_VALUE));
    }
}
