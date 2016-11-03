package ua.abond.homework.math;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class KaratsubaTest {

    @Test(expected = IllegalArgumentException.class)
    public void testLongKaratsubaMultiplicationBigArgs() throws Exception {
        Karatsuba.multiply(-423432421321L, -4322111321343L);
    }

    @Test
    public void testLongKaratsubaMultiplictaion() throws Exception {
        testLong(60782178934893L, 7709871, 7883683);
        testLong(28613244115155L, 8327523, 3435985);
        testLong(26610876766900L, 5678900, 4685921);

        testLong(-60782178934893L, -7709871, 7883683);
        testLong(-28613244115155L, 8327523, -3435985);
        testLong(26610876766900L, -5678900, -4685921);
    }

    @Test
    public void testKaratsubaMultiplication() throws Exception {
        testBigInt(60782178934893L, 7709871, 7883683);
        testBigInt(28613244115155L, 8327523, 3435985);
        testBigInt(26610876766900L, 5678900, 4685921);
    }

    @Test
    public void testKaratsubaMultiplicationWithZero() throws Exception {
        testBoth(0L, 0, 7883683);
        testBoth(0L, 7883683, 0);
        testBoth(0L, 0, -231231);
        testBoth(0L, -353231310, 0);
    }

    @Test
    public void testKaratsubaMultiplicationOfNegativeNumbers() throws Exception {
        testBigInt(-60782178934893L, -7709871, 7883683);
        testBigInt(-60782178934893L, 7709871, -7883683);
        testBigInt(60782178934893L, -7709871, -7883683);
        testBigInt(60782178934893L, -7709871, -7883683);
        testBigInt(55541959413582L, -13123221, -4232342);
        testBigInt(183012210663667203L, -423432421, -432211143);
        testBigInt(-183012210663667203L, -423432421, 432211143);
    }

    private void testLong(long expected, long x, long y) {
        assertEquals(expected, Karatsuba.multiply(x, y));
    }

    private void testBigInt(long expected, long x, long y) {
        assertEquals("Should work for BigInteger",
                BigInteger.valueOf(expected),
                Karatsuba.multiply(
                        BigInteger.valueOf(x),
                        BigInteger.valueOf(y)
                )
        );
    }

    private void testBoth(long expected, long x, long y) {
        testLong(expected, x, y);
        testBigInt(expected, x, y);
    }

}
