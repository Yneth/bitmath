package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SignTest {

    @Test
    public void testInt() {
        assertEquals(1, BitMath.sign(321321));
        assertEquals(1, BitMath.sign(4325124));
        assertEquals(1, BitMath.sign(543321255));
        assertEquals(1, BitMath.sign(6542342));
        assertEquals(1, BitMath.sign(643523));
        assertEquals(1, BitMath.sign(765215));

        assertEquals(-1, BitMath.sign(-438991));
        assertEquals(-1, BitMath.sign(-865325));
        assertEquals(-1, BitMath.sign(-548393));
        assertEquals(-1, BitMath.sign(-342542));
        assertEquals(-1, BitMath.sign(-753452));
        assertEquals(-1, BitMath.sign(-765322));
    }

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

    @Test
    public void testLong() {
        assertEquals(1, BitMath.sign(321321L));
        assertEquals(1, BitMath.sign(4325124L));
        assertEquals(1, BitMath.sign(543321255L));
        assertEquals(1, BitMath.sign(6542342L));
        assertEquals(1, BitMath.sign(643523L));
        assertEquals(1, BitMath.sign(765215L));

        assertEquals(-1, BitMath.sign(-438991L));
        assertEquals(-1, BitMath.sign(-865325L));
        assertEquals(-1, BitMath.sign(-548393L));
        assertEquals(-1, BitMath.sign(-342542L));
        assertEquals(-1, BitMath.sign(-753452L));
        assertEquals(-1, BitMath.sign(-765322L));
    }
}
