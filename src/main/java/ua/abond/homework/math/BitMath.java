package ua.abond.homework.math;

public final class BitMath {

    private BitMath() {
    }

    public static int sizeOf(byte x) {
        return Byte.SIZE;
    }

    public static int sizeOf(short x) {
        return Short.SIZE;
    }

    public static int sizeOf(int x) {
        return Integer.SIZE;
    }

    public static int sizeOf(long x) {
        return Long.SIZE;
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

    public static int subtract(int x, int y) {
        return add(x, negate(y));
    }

    public static long subtract(long x, long y) {
        return add(x, negate(y));
    }

    public static long remainder(long a, long divisor) {
        long q = 0;
        long r = abs(a);
        long d = abs(divisor);
        while (r >= d) {
            r = subtract(r, d);
            q = add(q, 1);
        }
        if (a < 0 && r > 0) {
            r = subtract(d, r);
            q = negate(add(q, 1));
        }
        return r;
    }

    public static int getBitLength(byte num) {
        if (num == Byte.MIN_VALUE) {
            return maxBit(num);
        }
        return getBitLength(maxBit(num), num);
    }

    public static int getBitLength(short num) {
        if (num == Short.MIN_VALUE) {
            return maxBit(num);
        }
        return getBitLength(maxBit(num), num);
    }

    public static int getBitLength(int num) {
        if (num == Integer.MIN_VALUE) {
            return maxBit(num);
        }
        return getBitLength(maxBit(num), num);
    }

    public static int getBitLength(long num) {
        if (Long.MIN_VALUE == num) {
            return maxBit(num);
        }
        return getBitLength(maxBit(num), num);
    }

    private static int getBitLength(int size, long num) {
        if (num == 0) {
            return 0;
        }

        long val = abs(num);
        for (int i = size; i > 0; i--) {
            if (((val >>> i) & 1) == 1) {
                return add(i, 1);
            }
        }
        return 1;
    }

    public static int negateBit(int num, int bitPos) {
        if (bitPos < 0) {
            throw new IllegalArgumentException("Pos argument should be greater than 0.");
        }
        return num ^ (1 << bitPos);
    }

    public static int gcd(int x, int y) {
        int shift;

        int u = abs(x);
        int v = abs(y);

        if (u == 0) {
            return v;
        }
        if (v == 0) {
            return u;
        }

        for (shift = 0; ((u | v) & 1) == 0; ++shift) {
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
            v = v - u;
        } while (v != 0);

        return u << shift;
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
}
