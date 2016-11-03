package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GcdTest {

    @Test
    public void testGcd() {
        assertEquals(4, BitMath.gcd(3832, 84));
        assertEquals(8, BitMath.gcd(312, 32));
        assertEquals(21, BitMath.gcd(231, 21));
        assertEquals(2, BitMath.gcd(432214, 32));
        assertEquals(23, BitMath.gcd(2231, 322));
        assertEquals(1, BitMath.gcd(434543, 6424));
        assertEquals(2, BitMath.gcd(3421342, 432));
        assertEquals(2, BitMath.gcd(321124, 21234));
        assertEquals(1, BitMath.gcd(3214, 321));
        assertEquals(3, BitMath.gcd(645, 654));
    }

    @Test
    public void testGcdWithNegativeValues() {
        assertEquals(7, BitMath.gcd(21, -14));
        assertEquals(4, BitMath.gcd(-32132, 32));
        assertEquals(1, BitMath.gcd(56783, -52));
        assertEquals(1, BitMath.gcd(-85663, -34838));
        assertEquals(3, BitMath.gcd(-534, 765));
        assertEquals(3, BitMath.gcd(534, -765));
    }

    @Test
    public void testGcdWithZero() {
        assertEquals(21, BitMath.gcd(21, 0));
        assertEquals(21, BitMath.gcd(0, 21));
    }

    @Test
    public void testGcdWithOne() {
        assertEquals(1, BitMath.gcd(21, 1));
        assertEquals(1, BitMath.gcd(-321321, 1));
        assertEquals(1, BitMath.gcd(1, 6214325));
    }
}
