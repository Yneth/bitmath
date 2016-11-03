package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SizeOfTest {

    @Test
    public void testSizeOfByteCornerCases() {
        byte zero = 0;

        assertEquals(8, BitMath.sizeOf(zero));
        assertEquals(8, BitMath.sizeOf(Byte.MAX_VALUE));
        assertEquals(8, BitMath.sizeOf(Byte.MIN_VALUE));
    }

    @Test
    public void testSizeOfByte() {
        byte val0 = 121;
        assertEquals(8, BitMath.sizeOf(val0));
        val0 = -12;
        assertEquals(8, BitMath.sizeOf(val0));
    }

    @Test
    public void testSizeOfShortCornerCases() {
        short zero = 0;
        assertEquals(16, BitMath.sizeOf(zero));
        assertEquals(16, BitMath.sizeOf(Short.MAX_VALUE));
        assertEquals(16, BitMath.sizeOf(Short.MIN_VALUE));
    }

    @Test
    public void testSizeOfShort() {
        short val0 = 32132;
        assertEquals(16, BitMath.sizeOf(val0));
        val0 = -3213;
        assertEquals(16, BitMath.sizeOf(val0));
    }

    @Test
    public void testSizeOfIntCornerCases() {
        assertEquals(32, BitMath.sizeOf(0));
        assertEquals(32, BitMath.sizeOf(Integer.MAX_VALUE));
        assertEquals(32, BitMath.sizeOf(Integer.MIN_VALUE));
    }

    @Test
    public void testSizeOfInt() {
        assertEquals(32, BitMath.sizeOf(321321311));
        assertEquals(32, BitMath.sizeOf(-3213424));
    }

    @Test
    public void testSizeOfLongCornerCases() {
        assertEquals(64, BitMath.sizeOf(0L));
        assertEquals(64, BitMath.sizeOf(Long.MAX_VALUE));
        assertEquals(64, BitMath.sizeOf(Long.MIN_VALUE));
    }

    @Test
    public void testSizeOfLong() {
        assertEquals(64, BitMath.sizeOf(3213213132132131L));
        assertEquals(64, BitMath.sizeOf(-3213424321312312L));
    }
}
