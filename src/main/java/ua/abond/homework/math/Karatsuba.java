package ua.abond.homework.math;

import java.math.BigInteger;

public final class Karatsuba {

    private static final int MULTIPLICATION_THRESHOLD = 15;

    private Karatsuba() {
    }

    public static long multiply(long x, long y) {
        int n = Math.max(BitMath.getBitLength(x), BitMath.getBitLength(y));

        if (n <= MULTIPLICATION_THRESHOLD) {
            return x * y;
        }

        n = n >> 1;

        long b = x >> n;
        long a = BitMath.subtract(x, b << n);
        long d = y >> n;
        long c = BitMath.subtract(y, d << n);

        long ac = multiply(a, c);
        long bd = multiply(b, d);
        long abcd = multiply(BitMath.add(a, b), BitMath.add(c, d));

        return BitMath.add(
                BitMath.add(ac, bd << (n << 1)),
                BitMath.subtract(
                        BitMath.subtract(abcd, ac),
                        bd
                ) << n
        );
    }

    public static BigInteger multiply(BigInteger x, BigInteger y) {
        int n = Math.max(x.bitLength(), y.bitLength());

        if (n <= MULTIPLICATION_THRESHOLD) {
            return x.multiply(y);
        }

        n = n >> 1;

        // x = b * 2^n + a   y = d * 2^n + c
        BigInteger b = x.shiftRight(n);
        BigInteger a = x.subtract(b.shiftLeft(n));
        BigInteger d = y.shiftRight(n);
        BigInteger c = y.subtract(d.shiftLeft(n));

        BigInteger ac = multiply(a, c);
        BigInteger bd = multiply(b, d);
        BigInteger abcd = multiply(a.add(b), c.add(d));

        // ac + (abcd - ac - bd) * 2^n + bd * 2^(2*n)
        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(n)).add(bd.shiftLeft(n << 1));
    }
}
