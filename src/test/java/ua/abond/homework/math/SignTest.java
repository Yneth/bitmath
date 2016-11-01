package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SignTest {

    @Test
    public void testIntSignCornerCases() {
        assertEquals(0, BitMath.sign(0));
        assertEquals(-1, BitMath.sign(Integer.MIN_VALUE));
        assertEquals(1, BitMath.sign(Integer.MAX_VALUE));
    }

    @Test
    public void testLongSignCornerCases() {
        assertEquals(0, BitMath.sign(0L));
        assertEquals(-1, BitMath.sign(Long.MIN_VALUE));
        assertEquals(1, BitMath.sign(Long.MAX_VALUE));
    }
}
