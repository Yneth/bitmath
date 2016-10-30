package ua.abond.homework.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyMathTest {

    @Test
    public void testUsedBitsWithZeroByte() {
        byte value = 0;
        assertEquals("Should work with 0", 0, MyMath.numberOfUsedBits(value));
    }

    @Test
    public void testUsedBitsWithShortByte() {
        short value = 0;
        assertEquals("Should work with 0", 0, MyMath.numberOfUsedBits(value));
    }

    @Test
    public void testUsedBitsWithIntegerByte() {
        int value = 0;
        assertEquals("Should work with 0", 0, MyMath.numberOfUsedBits(value));
    }

    @Test
    public void testUsedBitsWithLongByte() {
        long value = 0;
        assertEquals("Should work with 0", 0, MyMath.numberOfUsedBits(value));
    }

    @Test
    public void testUsedBitsPositiveCornerByteCases() {
        byte value = 1;
        assertEquals("Should work with 1", 1, MyMath.numberOfUsedBits(value));
        assertEquals("Should work with Byte.MAX_VALUE", 6, MyMath.numberOfUsedBits(Byte.MAX_VALUE));
    }

    @Test
    public void testUsedBitsNegativeCornerByteCases() {
        byte value = -1;
        assertEquals("Should work with negative 1", 1, MyMath.numberOfUsedBits(value));
        assertEquals("Should work with Byte.MIN_VALUE", 7, MyMath.numberOfUsedBits(Byte.MIN_VALUE));
    }

    @Test
    public void testUsedBitsPositiveCornerShortCases() {
        int value = 1;
        assertEquals("Should work with 1", 1, MyMath.numberOfUsedBits(value));
        assertEquals("Should work with Short.MAX_VALUE", 14, MyMath.numberOfUsedBits(Short.MAX_VALUE));
    }

    @Test
    public void testUsedBitsNegativeCornerShortCases() {
        int value = -1;
        assertEquals("Should work with negative 1", 1, MyMath.numberOfUsedBits(value));
        assertEquals("Should work with Short.MIN_VALUE", 15, MyMath.numberOfUsedBits(Short.MIN_VALUE));
    }

    @Test
    public void testUsedBitsPositiveCornerIntegerCases() {
        int value = 1;
        assertEquals("Should work with 1", 1, MyMath.numberOfUsedBits(value));
        assertEquals("Should work with Integer.MAX_VALUE", 30, MyMath.numberOfUsedBits(Integer.MAX_VALUE));
    }

    @Test
    public void testUsedBitsNegativeCornerIntegerCases() {
        int value = -1;
        assertEquals("Should work with negative 1", 1, MyMath.numberOfUsedBits(value));
        assertEquals("Should work with Integer.MIN_VALUE", 31, MyMath.numberOfUsedBits(Integer.MIN_VALUE));
    }

    @Test
    public void testUsedBitsPositiveCornerLongCases() {
        int value = 1;
        assertEquals("Should work with 1", 1, MyMath.numberOfUsedBits(value));
        assertEquals("Should work with Long.MAX_VALUE", 60, MyMath.numberOfUsedBits(Long.MAX_VALUE));
    }

    @Test
    public void testUsedBitsNegativeCornerLongCases() {
        int value = -1;
        assertEquals("Should work with negative 1", 1, MyMath.numberOfUsedBits(value));
        assertEquals("Should work with Long.MIN_VALUE", 61, MyMath.numberOfUsedBits(Long.MIN_VALUE));
    }

    @Test
    public void testNegateBit() {
        assertEquals(12345678 + (1 << 7), MyMath.negateBit(12345678, 7));
        assertEquals(-12345678 - (1 << 7), MyMath.negateBit(-12345678, 7));
    }

    @Test
    public void testNegateBitWithZero() {
        for (int i = 0; i < 32; i++) {
            assertEquals(1 << i, MyMath.negateBit(0, i));
        }
    }

    @Test
    public void testNegateBitWithFactorsOfTwo() {
        for (int i = 0; i < 32; i++) {
            assertEquals(0, MyMath.negateBit(1 << i, i));
        }
    }

    @Test
    public void testNegateBitWithNegativeValues() {
        assertEquals(-264, MyMath.negateBit(-256, 3));
    }

    @Test
    public void testNegateBitWithPositiveValues() {
        assertEquals(264, MyMath.negateBit(256, 3));

        assertEquals(0L, MyMath.negateBit(8, 3));
    }

    @Test
    public void testGcd() {
        assertEquals(7, MyMath.gcd(21, 14));
        assertEquals(7, MyMath.gcd(14, 21));
    }

    @Test
    public void testNegativeGcd() {
        assertEquals(7, MyMath.gcd(21, -14));
        assertEquals(7, MyMath.gcd(-14, 21));
        assertEquals(7, MyMath.gcd(-14, -21));
    }

    @Test
    public void testKaratsubaMultiplication() {
        assertEquals(60782178934893L, MyMath.karatsuba(7709871, 7883683));
        assertEquals(-60782178934893L, MyMath.karatsuba(7709871, -7883683));
        assertEquals(60782178934893L, MyMath.karatsuba(-7709871, -7883683));
    }

}
