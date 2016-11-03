package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinValueTest {

    @Test
    public void test() {
        assertEquals(Byte.MIN_VALUE, BitMath.minValue((byte) 1));
        assertEquals(Short.MIN_VALUE, BitMath.minValue((short) 1));
        assertEquals(Integer.MIN_VALUE, BitMath.minValue(1));
        assertEquals(Long.MIN_VALUE, BitMath.minValue(1L));

        assertEquals(Byte.MIN_VALUE, BitMath.minValue((byte) 12));
        assertEquals(Short.MIN_VALUE, BitMath.minValue((short) 32));
        assertEquals(Integer.MIN_VALUE, BitMath.minValue(32312));
        assertEquals(Long.MIN_VALUE, BitMath.minValue(2313127L));

        assertEquals(Byte.MIN_VALUE, BitMath.minValue((byte) 54));
        assertEquals(Short.MIN_VALUE, BitMath.minValue((short) 231));
        assertEquals(Integer.MIN_VALUE, BitMath.minValue(321441));
        assertEquals(Long.MIN_VALUE, BitMath.minValue(4322432L));
    }

    @Test
    public void testCornerCases() {
        assertEquals(Byte.MIN_VALUE, BitMath.minValue((byte) 0));
        assertEquals(Short.MIN_VALUE, BitMath.minValue((short) 0));
        assertEquals(Integer.MIN_VALUE, BitMath.minValue(0));
        assertEquals(Long.MIN_VALUE, BitMath.minValue(0L));

        assertEquals(Byte.MIN_VALUE, BitMath.minValue(Byte.MIN_VALUE));
        assertEquals(Short.MIN_VALUE, BitMath.minValue(Short.MIN_VALUE));
        assertEquals(Integer.MIN_VALUE, BitMath.minValue(Integer.MIN_VALUE));
        assertEquals(Long.MIN_VALUE, BitMath.minValue(Long.MIN_VALUE));

        assertEquals(Byte.MIN_VALUE, BitMath.minValue(Byte.MAX_VALUE));
        assertEquals(Short.MIN_VALUE, BitMath.minValue(Short.MAX_VALUE));
        assertEquals(Integer.MIN_VALUE, BitMath.minValue(Integer.MAX_VALUE));
        assertEquals(Long.MIN_VALUE, BitMath.minValue(Long.MAX_VALUE));
    }
}
