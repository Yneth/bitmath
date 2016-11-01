package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BitLengthTest {

    @Test
    public void testByteBitLength() {
        byte value = 0;
        assertEquals(0, BitMath.getBitLength(value));
    }

    @Test
    public void testByteBitLengthCornerCases() {
        byte value = 1;
        assertEquals(1, BitMath.getBitLength(value));
        value = 0;
        assertEquals(0, BitMath.getBitLength(value));
        assertEquals(7, BitMath.getBitLength(Byte.MAX_VALUE));
        assertEquals(7, BitMath.getBitLength(Byte.MIN_VALUE));
    }

    @Test
    public void testShortBitLength() {
        short value = 0;
        assertEquals(0, BitMath.getBitLength(value));
    }

    @Test
    public void testShortBitLengthCornerCases() {
        short value = 1;
        assertEquals(1, BitMath.getBitLength(value));
        value = 0;
        assertEquals(0, BitMath.getBitLength(value));

        assertEquals(15, BitMath.getBitLength(Short.MAX_VALUE));
        assertEquals(15, BitMath.getBitLength(Short.MIN_VALUE));
    }

    @Test
    public void testIntegerBitLength() {
        int value = 0;
        assertEquals(0, BitMath.getBitLength(value));
    }

    @Test
    public void testIntegerBitLengthCornerCases() {
        int value = 1;
        assertEquals(1, BitMath.getBitLength(value));
        value = 0;
        assertEquals(0, BitMath.getBitLength(value));
        assertEquals(31, BitMath.getBitLength(Integer.MAX_VALUE));
        assertEquals(31, BitMath.getBitLength(Integer.MIN_VALUE));
    }

    @Test
    public void testLongBitLength() {
        long value = 0;
        assertEquals(0, BitMath.getBitLength(value));
    }

    @Test
    public void testLongBitLengthCornerCases() {
        long value = 1;
        assertEquals(1, BitMath.getBitLength(value));
        value = 0;
        assertEquals(0, BitMath.getBitLength(value));
        assertEquals(63, BitMath.getBitLength(Long.MAX_VALUE));
        assertEquals(63, BitMath.getBitLength(Long.MIN_VALUE));
    }
}
