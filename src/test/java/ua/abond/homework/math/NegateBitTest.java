package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NegateBitTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNegateBitWrongArgumentCornerCase() {
        BitMath.negateBit(-12345678, Integer.MIN_VALUE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegateBitWrongArgument() {
        BitMath.negateBit(-12345678, 33);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegateBitWrongArgument2() {
        BitMath.negateBit(-12345678, 32);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegateBitNegativeArgument() {
        BitMath.negateBit(-12345678, -1);
    }

    @Test
    public void testNegateBit() {
        assertEquals(-12345678 - (1 << 7), BitMath.negateBit(-12345678, 7));
        assertEquals(-12345678 - (1 << 7), BitMath.negateBit(-12345678, 7));
        assertEquals(-43232 + (1 << 2), BitMath.negateBit(-43232, 2));
        assertEquals(-543232 + (1 << 4), BitMath.negateBit(-543232, 4));
        assertEquals(-4232132 + (1 << 7), BitMath.negateBit(-4232132, 7));
        assertEquals(-65432 + (1 << 7), BitMath.negateBit(-65432, 7));
        assertEquals(-321 - (1 << 20), BitMath.negateBit(-321, 20));
        assertEquals(-4232132 - (1 << 30), BitMath.negateBit(-4232132, 30));
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
        assertEquals(12345678 + (1 << 7), BitMath.negateBit(12345678, 7));
        assertEquals(43232 + (1 << 2), BitMath.negateBit(43232, 2));
        assertEquals(543232 + (1 << 4), BitMath.negateBit(543232, 4));
        assertEquals(4232132 - (1 << 7), BitMath.negateBit(4232132, 7));
        assertEquals(65432 - (1 << 7), BitMath.negateBit(65432, 7));
        assertEquals(321 + (1 << 31), BitMath.negateBit(321, 31));
        assertEquals(4232132 + (1 << 30), BitMath.negateBit(4232132, 30));
    }
}
