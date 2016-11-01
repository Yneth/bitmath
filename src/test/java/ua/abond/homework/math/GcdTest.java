package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GcdTest {

    @Test
    public void testGcd() {
        assertEquals(4, BitMath.gcd(3832,84));
        assertEquals(4, BitMath.gcd(232, 214332));
    }

    @Test
    public void testGcdWithNegativeValues() {
        assertEquals(7, BitMath.gcd(21, -14));
        assertEquals(4, BitMath.gcd(-32132, 32));
        assertEquals(1, BitMath.gcd(56783, -52));
        assertEquals(1, BitMath.gcd(-85663, -34838));
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
    }
}
