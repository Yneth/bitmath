package ua.abond.homework.math;

import java.lang.Math;
import java.math.BigInteger;

public final class MyMath {
    private static final int MULTIPLICATION_THRESHOLD = 15;

    private MyMath() {
    }

    private static int numberOfUsedBits(int size, long num) {
        if (num == 0) return 0;

        long val = Math.abs(num);
        for (int i = size; i > 0; i--) {
            if (val >>> i > 0) {
                return i;
            }
        }
        return 1;
    }

    public static int numberOfUsedBits(byte num) {
        return numberOfUsedBits(7, num);
    }

    public static int numberOfUsedBits(short num) {
        return numberOfUsedBits(15, num);
    }

    public static int numberOfUsedBits(int num) {
        return numberOfUsedBits(31, num);
    }

    public static int numberOfUsedBits(long num) {
        if (Long.MIN_VALUE == num) return 61;
        return numberOfUsedBits(60, num);
    }

    public static int negateBit(int num, int pos) {
        if (pos < 0) {
            throw new IllegalArgumentException("Pos argument should be greater than 0.");
        }
        int val = Math.abs(num);
        int bit = 1 << pos;

        bit = ((val >> pos) & 1) == 1 ? -bit : bit;
        bit = num < 0 ? -bit : bit;

        return num + bit;
    }

    public static long gcd(long x, long y) {
        long a = x;
        long b = y;
        while (b != 0) {
            long aTemp = a;
            a = b;
            b = remainder(aTemp, b);
        }
        return a;
    }

    public static long remainder(long a, long divisor) {
        long q = 0;
        long r = Math.abs(a);
        long d = Math.abs(divisor);
        while (r >= d) {
            r = r - d;
            q = q + 1;
        }
        if (a < 0 && r > 0) {
            r = d - r;
            q = -(q + 1);
        }
        return r;
    }

    public static long karatsuba(long x, long y) {
        int n = Math.max(numberOfUsedBits(x), numberOfUsedBits(y));

        if (n <= 15) {
            return x * y;
        }

        n = n >> 1;

        long b = x >> n;
        long a = x - (b << n);
        long d = y >> n;
        long c = y - (d << n);

        long ac = karatsuba(a, c);
        long bd = karatsuba(b, d);
        long abcd = karatsuba(a + b, c + d);

        return ac + ((abcd - ac - bd) << n) + (bd << (2 * n));
    }

    public static BigInteger karatsuba(BigInteger x, BigInteger y) {
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

        BigInteger ac = karatsuba(a, c);
        BigInteger bd = karatsuba(b, d);
        BigInteger abcd = karatsuba(a.add(b), c.add(d));

        // ac + (abcd - ac - bd) * 2^n + bd * 2^(2*n)
        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(n)).add(bd.shiftLeft(2 * n));
    }
}
