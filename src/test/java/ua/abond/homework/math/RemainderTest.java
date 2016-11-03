package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemainderTest {

    @Test(expected = IllegalArgumentException.class)
    public void testRemainderWithZeroDivisor() throws Exception {
        assertEquals(7, BitMath.remainder(21, 0));
    }

    @Test
    public void testRemainderCornerCases() throws Exception {
        assertEquals(1, BitMath.remainder(1, Integer.MAX_VALUE));
        assertEquals(0, BitMath.remainder(Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertEquals(0, BitMath.remainder(Integer.MIN_VALUE, Integer.MIN_VALUE));
        assertEquals(0, BitMath.remainder(0, Integer.MIN_VALUE));
        assertEquals(0, BitMath.remainder(0, Integer.MAX_VALUE));
    }

    @Test
    public void testRemainder() throws Exception {
        assertEquals(7, BitMath.remainder(21, 14));
        assertEquals(432, BitMath.remainder(432, 5433));
        assertEquals(3421, BitMath.remainder(7652, 4231));
        assertEquals(500, BitMath.remainder(54364, 6733));
        assertEquals(7380, BitMath.remainder(76526, 9878));
        assertEquals(1103, BitMath.remainder(8622543, 2432));
        assertEquals(76601, BitMath.remainder(954389, 97532));
        assertEquals(0, BitMath.remainder(2312, 2));
        assertEquals(0, BitMath.remainder(765431602, 2));
        assertEquals(0, BitMath.remainder(52312, 2));
    }

    @Test
    public void testNegativeDivisor() throws Exception {
        assertEquals(7, BitMath.remainder(21, -14));
        assertEquals(0, BitMath.remainder(321321, -321));
        assertEquals(42, BitMath.remainder(433225, -211));
        assertEquals(34, BitMath.remainder(837828, -49282));
        assertEquals(-156, BitMath.remainder(-3792881, -211));
        assertEquals(-171, BitMath.remainder(-873922, -211));
        assertEquals(70111, BitMath.remainder(786546789, -86798));
    }
}
