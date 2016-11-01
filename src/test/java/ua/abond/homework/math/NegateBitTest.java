package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NegateBitTest {

    @Test
    public void testNegateBit() {
        assertEquals(12345678 + (1 << 7), BitMath.negateBit(12345678, 7));
        assertEquals(-12345678 - (1 << 7), BitMath.negateBit(-12345678, 7));
    }

    @Test
    public void testNegateBitWithZero() {
        for (int i = 0; i < 32; i++) {
            assertEquals(1 << i, BitMath.negateBit(0, i));
        }
    }

    @Test
    public void testNegateBitWithFactorsOfTwo() {
        for (int i = 0; i < 32; i++) {
            assertEquals(0, BitMath.negateBit(1 << i, i));
        }
    }

    @Test
    public void testNegateBitWithNegativeValues() {
        assertEquals(-248, BitMath.negateBit(-256, 3));
    }

    @Test
    public void testNegateBitWithPositiveValues() {
        assertEquals(264, BitMath.negateBit(256, 3));

        assertEquals(0L, BitMath.negateBit(8, 3));
    }
}
