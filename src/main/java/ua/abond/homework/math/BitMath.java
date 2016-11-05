package ua.abond.homework.math;

public final class BitMath {

    private BitMath() {
    }

    public static int sizeOf(byte x) {
        int res = 0;

        byte val = 1;
        while (val != 0) {
            val <<= 1;
            res = increment(res);
        }
        return res;
    }

    public static int sizeOf(short x) {
        int res = 0;

        short val = 1;
        while (val != 0) {
            val <<= 1;
            res = increment(res);
        }
        return res;
    }

    public static int sizeOf(int x) {
        int res = 0;

        int val = 1;
        while (val != 0) {
            val <<= 1;
            res = increment(res);
        }
        return res;
    }

    public static int sizeOf(long x) {
        int res = 0;

        long val = 1;
        while (val != 0) {
            val <<= 1;
            res = increment(res);
        }
        return res;
    }

    public static int toggleBit(int num, int bitPos) {
        if (bitPos < 0 || bitPos >= sizeOf(num)) {
            throw new IllegalArgumentException("Pos argument should be between 0 and 32.");
        }
        int mask = 1 << bitPos;
        return num ^ mask;
    }

    public static int gcd(int x, int y) {
        int shift;

        int u = abs(x);
        int v = abs(y);
        if (u == 0 || v == 0) {
            throw new IllegalArgumentException("None of the arguments can be equal to zero.");
        }

        for (shift = 0; ((u | v) & 1) == 0; shift = increment(shift)) {
            u >>= 1;
            v >>= 1;
        }

        while ((u & 1) == 0) {
            u >>= 1;
        }
        do {
            while ((v & 1) == 0) {
                v >>= 1;
            }

            if (u > v) {
                int t = v;
                v = u;
                u = t;
            }
            v = subtract(v, u);
        } while (v != 0);

        return u << shift;
    }

    public static int maxBit(byte x) {
        return subtract(sizeOf(x), 1);
    }

    public static int maxBit(short x) {
        return subtract(sizeOf(x), 1);
    }

    public static int maxBit(int x) {
        return subtract(sizeOf(x), 1);
    }

    public static int maxBit(long x) {
        return subtract(sizeOf(x), 1);
    }

    public static int abs(int x) {
        int maxBit = maxBit(x);
        return subtract(x ^ (x >> maxBit), x >> maxBit);
    }

    public static long abs(long x) {
        int maxBit = maxBit(x);
        return subtract(x ^ (x >> maxBit), x >> maxBit);
    }

    public static int negate(int x) {
        return add(1, ~x);
    }

    public static long negate(long x) {
        return add(1, ~x);
    }

    public static int sign(int x) {
        if (x == 0) {
            return 0;
        }
        if (x >> maxBit(x) != 0) {
            return -1;
        }
        return +1;
    }

    public static int sign(long x) {
        if (x == 0) {
            return 0;
        }
        if (x >> maxBit(x) != 0) {
            return -1;
        }
        return +1;
    }

    public static int add(int x, int y) {
        int result = x ^ y;
        int carry = (x & y) << 1;

        while (carry != 0) {
            int borrow = result & carry;

            result = result ^ carry;

            carry = borrow << 1;
        }
        return result;
    }

    public static long add(long x, long y) {
        long result = x ^ y;
        long carry = (x & y) << 1;

        while (carry != 0) {
            long borrow = result & carry;

            result = result ^ carry;

            carry = borrow << 1;
        }
        return result;
    }

    public static int increment(int x) {
        return add(x, 1);
    }

    public static long increment(long x) {
        return add(x, 1);
    }

    public static int subtract(int x, int y) {
        return add(x, negate(y));
    }

    public static long subtract(long x, long y) {
        return add(x, negate(y));
    }

    public static int decrement(int x) {
        return subtract(x, 1);
    }

    public static long multiply(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (bitLength(a) + bitLength(b) > sizeOf(a)) {
            throw new IllegalArgumentException("Passed arguments are too big.");
        }
        long result = 0;
        long x = a;
        long y = b;
        while (y != 0) {
            if ((y & 1) != 0) {
                result = add(result, x);
            }
            x <<= 1;
            y >>>= 1;
        }
        return result;
    }

    public static long pow(long value, long exponent) {
        long a = exponent;
        long b = value;
        long result = 1;
        while (a > 1) {
            if ((a & 1) != 0) {
                result = multiply(result, b);
            }
            b = multiply(b, b);
            a >>= 1;
        }
        if (a > 0) {
            result = multiply(result, b);
        }
        return result;
     }

    public static long remainder(long a, long divisor) {
        long r = divide(a, divisor);
        return subtract(a, multiply(r, divisor));
    }

    public static long divide(long dividend, long divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        if (divisor == 1) {
            return dividend;
        }

        long sign = multiply(sign(dividend), sign(divisor));

        long scaledDivisor = abs(divisor);
        long remain = abs(dividend);
        long result = 0;
        long multiple = 1;

        while (scaledDivisor < remain) {
            scaledDivisor = scaledDivisor << 1;
            multiple = multiple << 1;
        }
        do {
            if (remain >= scaledDivisor) {
                remain = subtract(remain, scaledDivisor);
                result = add(result, multiple);
            }
            scaledDivisor = scaledDivisor >> 1;
            multiple = multiple >> 1;
        } while (multiple != 0);

        if (sign < 0) {
            result = negate(result);
        }
        return result;
    }

    public static int bitLength(int res, int i) {
        if (i == 0)
            return 0;
        int x = abs(i);
        int n = res;
        int size = sizeOf(x);
        int shift = 16;
        while ((shift & increment(shift)) != 0) {
            if (x >>> shift == 0) {
                int s = subtract(size, shift);
                n = subtract(n, s);
                x <<= s;
            }
            shift |= (shift >> 1);
        }
        if (x >>> shift == 0) {
            n = decrement(n);
        }
        return n;
    }

    public static int bitLength(byte i) {
        int size = sizeOf(i);
        if (i == minValue(i)) {
            return size - 1;
        }
        return bitLength(size, i << 24);
    }

    public static int bitLength(short i) {
        int size = sizeOf(i);
        if (i == minValue(i)) {
            return size - 1;
        }
        return bitLength(size, i << 16);
    }

    public static int bitLength(int i) {
        int size = sizeOf(i);
        if (i == minValue(i)) {
            return size - 1;
        }
        return bitLength(size, i);
    }

    public static int bitLength(long i) {
        int n = sizeOf(i);
        if (i == minValue(i)) {
            return n - 1;
        }
        int x = (int) (abs(i) >>> 32);
        if (x == 0) {
            n = subtract(n, 32);
            x = (int) i;
        }
        return bitLength(n, x);
    }

    public static byte minValue(byte x) {
        return (byte) negate(1 << decrement(sizeOf(x)));
    }

    public static short minValue(short x) {
        return (short) negate(1 << decrement(sizeOf(x)));
    }

    public static int minValue(int x) {
        return negate(1 << decrement(sizeOf(x)));
    }

    public static long minValue(long x) {
        return negate(1L << decrement(sizeOf(x)));
    }
}
