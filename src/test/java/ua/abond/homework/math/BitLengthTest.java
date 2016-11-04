package ua.abond.homework.math;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class BitLengthTest {

    @Test
    public void testByteBitLength() throws Exception {
        byte value = 0;
        assertEquals(0, BitMath.bitLength(value));
    }

    @Test
    public void testByteBitLengthNegative() throws Exception {
        byte value = -1;
        assertEquals(1, BitMath.bitLength(value));
        value = -100;
        assertEquals(7, BitMath.bitLength(value));
    }

    @Test
    public void testByteBitLengthCornerCases() throws Exception {
        byte value = 1;
        assertEquals(1, BitMath.bitLength(value));
        value = 0;
        assertEquals(0, BitMath.bitLength(value));
        assertEquals(BigInteger.valueOf(Byte.MAX_VALUE).bitLength(), BitMath.bitLength(Byte.MAX_VALUE));
        assertEquals(BigInteger.valueOf(Byte.MIN_VALUE).bitLength(), BitMath.bitLength(Byte.MIN_VALUE));
    }

    @Test
    public void testShortBitLength() throws Exception {
        short value = 0;
        assertEquals(0, BitMath.bitLength(value));
    }

    @Test
    public void testShortBitLengthCornerCases() throws Exception {
        short value = 1;
        assertEquals(1, BitMath.bitLength(value));
        value = 0;
        assertEquals(0, BitMath.bitLength(value));
        value = -1;
        assertEquals(1, BitMath.bitLength(value));

        assertEquals(BigInteger.valueOf(Short.MIN_VALUE).bitLength(), BitMath.bitLength(Short.MIN_VALUE));
        assertEquals(BigInteger.valueOf(Short.MAX_VALUE).bitLength(), BitMath.bitLength(Short.MAX_VALUE));
    }

    @Test
    public void testIntegerBitLength() throws Exception {
        int value = 0;
        assertEquals(0, BitMath.bitLength(value));
        assertEquals(BigInteger.valueOf(3213123).bitLength(), BitMath.bitLength(3213123));
        assertEquals(BigInteger.valueOf(439827854).bitLength(), BitMath.bitLength(439827854));
        assertEquals(BigInteger.valueOf(1234322).bitLength(), BitMath.bitLength(1234322));
        assertEquals(BigInteger.valueOf(53891054).bitLength(), BitMath.bitLength(53891054));
        assertEquals(BigInteger.valueOf(837723829).bitLength(), BitMath.bitLength(837723829));
        assertEquals(BigInteger.valueOf(43892010).bitLength(), BitMath.bitLength(43892010));
        assertEquals(BigInteger.valueOf(92747738).bitLength(), BitMath.bitLength(92747738));
    }

    @Test
    public void testIntegerBitLengthCornerCases() throws Exception {
        int value = 1;
        assertEquals(1, BitMath.bitLength(value));
        value = 0;
        assertEquals(0, BitMath.bitLength(value));
        assertEquals(1, BitMath.bitLength(-1));
        assertEquals(BigInteger.valueOf(Integer.MAX_VALUE).bitLength(), BitMath.bitLength(Integer.MAX_VALUE));
        assertEquals(BigInteger.valueOf(Integer.MIN_VALUE).bitLength(), BitMath.bitLength(Integer.MIN_VALUE));
    }

    @Test
    public void testLongBitLength() throws Exception {
        long value = 0;
        assertEquals(0, BitMath.bitLength(value));
        assertEquals(BigInteger.valueOf(60782178934893L).bitLength(), BitMath.bitLength(60782178934893L));
        assertEquals(BigInteger.valueOf(321321783721821L).bitLength(), BitMath.bitLength(321321783721821L));
        assertEquals(BigInteger.valueOf(231893712981281L).bitLength(), BitMath.bitLength(231893712981281L));
        assertEquals(BigInteger.valueOf(47328478328432888L).bitLength(), BitMath.bitLength(47328478328432888L));
        assertEquals(BigInteger.valueOf(595995959599912112L).bitLength(), BitMath.bitLength(595995959599912112L));
        assertEquals(BigInteger.valueOf(5435432839201583892L).bitLength(), BitMath.bitLength(5435432839201583892L));
        assertEquals(BigInteger.valueOf(923904329923922111L).bitLength(), BitMath.bitLength(923904329923922111L));
        assertEquals(BigInteger.valueOf(214329291912019199L).bitLength(), BitMath.bitLength(214329291912019199L));
    }

    @Test
    public void testLongBitLengthCornerCases() throws Exception {
        assertEquals(1, BitMath.bitLength(1L));
        assertEquals(0, BitMath.bitLength(0L));
        assertEquals(1, BitMath.bitLength(-1L));
        assertEquals(BigInteger.valueOf(Long.MAX_VALUE).bitLength(), BitMath.bitLength(Long.MAX_VALUE));
        assertEquals(BigInteger.valueOf(Long.MAX_VALUE).bitLength(), BitMath.bitLength(Long.MIN_VALUE));
    }
}
