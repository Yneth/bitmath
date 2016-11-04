package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivideTest {


    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() throws Exception {
        BitMath.divide(3213, 0);
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(3242, BitMath.divide(6484, 2));
        assertEquals(302902902L, BitMath.divide(3634834824L, 12));
        assertEquals(0, BitMath.divide(1, 43232423));
        assertEquals(65423992, BitMath.divide(1439327824, 22));
        assertEquals(1540414, BitMath.divide(854929832, 555));
        assertEquals(83234, BitMath.divide(54928982889L, 659929));

        assertEquals(-38478292, BitMath.divide(20893712556L, -543));
        assertEquals(-654353423, BitMath.divide(-3554447793736L, 5432));
        assertEquals(0, BitMath.divide(-1, -43232423));
        assertEquals(-33306, BitMath.divide(1439327824, -43214));
        assertEquals(-2443, BitMath.divide(-854929832, 349892));
        assertEquals(-6666, BitMath.divide(-54928982889L, 8239929));
    }

    @Test
    public void testDivideCornerCases() throws Exception {
        assertEquals(1, BitMath.divide(Long.MAX_VALUE, Long.MAX_VALUE));
        assertEquals(1, BitMath.divide(Long.MIN_VALUE, Long.MIN_VALUE));
        assertEquals(Long.MAX_VALUE, BitMath.divide(Long.MAX_VALUE, 1));
        assertEquals(0, BitMath.divide(1, Long.MAX_VALUE));
        assertEquals(Long.MIN_VALUE, BitMath.divide(Long.MIN_VALUE, 1));
        assertEquals(1, BitMath.divide(Long.MAX_VALUE, Long.MAX_VALUE));
    }
}
