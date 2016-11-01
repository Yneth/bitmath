package ua.abond.homework.math;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class KaratsubaTest {

    @Test
    public void testKaratsubaMultiplication() {
        testMultiplication(60782178934893L, 7709871, 7883683);
        testMultiplication(28613244115155L, 8327523, 3435985);
        testMultiplication(26610876766900L, 5678900, 4685921);
    }

    @Test
    public void testKaratsubaMultiplicationWithZero() {
        testMultiplication(0L, 0, 7883683);
        testMultiplication(0L, 7883683, 0);
    }

    @Test
    public void testKaratsubaMultiplicationOfNegativeNumbers() {
        testMultiplication(-60782178934893L, -7709871, 7883683);
        testMultiplication(-60782178934893L, 7709871, -7883683);
        testMultiplication(60782178934893L, -7709871, -7883683);
    }

    private void testMultiplication(long expected, long x, long y) {
        assertEquals("Should work for Long", expected, Karatsuba.multiply(x, y));
        assertEquals("Should work for BigInteger",
                BigInteger.valueOf(expected),
                Karatsuba.multiply(
                    BigInteger.valueOf(x),
                    BigInteger.valueOf(y)
                )
        );
    }

}
