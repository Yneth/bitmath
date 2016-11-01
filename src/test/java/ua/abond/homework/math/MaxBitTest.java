package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxBitTest {

    @Test
    public void testByteMaxBit() {
        int expected = Byte.SIZE - 1;
        byte value = 32;
        byte zero = 0;
        assertEquals(expected, BitMath.maxBit(value));
        assertEquals(expected, BitMath.maxBit(zero));
        assertEquals(expected, BitMath.maxBit(Byte.MAX_VALUE));
        assertEquals(expected, BitMath.maxBit(Byte.MIN_VALUE));
    }

    @Test
    public void testShortMaxBit() {
        int expected = Short.SIZE - 1;
        short value = 32132;
        short zero = 0;
        assertEquals(expected, BitMath.maxBit(value));
        assertEquals(expected, BitMath.maxBit(zero));
        assertEquals(expected, BitMath.maxBit(Short.MAX_VALUE));
        assertEquals(expected, BitMath.maxBit(Short.MIN_VALUE));
    }

    @Test
    public void testIntegerMaxBit() {
        int expected = Integer.SIZE - 1;
        int value = 32132321;
        assertEquals(expected, BitMath.maxBit(value));
        assertEquals(expected, BitMath.maxBit(0));
        assertEquals(expected, BitMath.maxBit(Integer.MAX_VALUE));
        assertEquals(expected, BitMath.maxBit(Integer.MIN_VALUE));
    }

    @Test
    public void testLongMaxBit() {
        int expected = Long.SIZE - 1;
        long value = 32132321321312L;
        assertEquals(expected, BitMath.maxBit(value));
        assertEquals(expected, BitMath.maxBit(0L));
        assertEquals(expected, BitMath.maxBit(Long.MAX_VALUE));
        assertEquals(expected, BitMath.maxBit(Long.MIN_VALUE));
    }
}
