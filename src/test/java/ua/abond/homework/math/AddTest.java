package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddTest {

    @Test
    public void testAdd() throws Exception {
        assertEquals(54331246, BitMath.add(27165623, 27165623));
        assertEquals(74820, BitMath.add(18705, BitMath.add(18705, BitMath.add(18705, 18705))));
    }

    @Test
    public void testAdditionOfNegativeValues() throws Exception {
        assertEquals(11, BitMath.add(12, -1));
        assertEquals(2, BitMath.add(33123122, -33123120));

        assertEquals(647956, BitMath.add(-647956, 1295912));
        assertEquals(-388282, BitMath.add(-1164846, 776564));

        assertEquals(-98836, BitMath.add(-49418, -49418));
        assertEquals(-57595, BitMath.add(-50000, -7595));
    }

    @Test
    public void testCornerCasesOfAdd() throws Exception {
        assertEquals(Integer.MIN_VALUE, BitMath.add(Integer.MIN_VALUE, 0));
        assertEquals(Integer.MIN_VALUE, BitMath.add(0, Integer.MIN_VALUE));

        assertEquals(-1, BitMath.add(Integer.MIN_VALUE, Integer.MAX_VALUE));

        assertEquals(0, BitMath.add(0, 0));

        assertEquals(Integer.MIN_VALUE, BitMath.add(Integer.MAX_VALUE, 1));
        assertEquals(Integer.MAX_VALUE, BitMath.add(Integer.MIN_VALUE, -1));
    }
}
