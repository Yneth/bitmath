package ua.abond.homework.crypto.rsa;

import ua.abond.homework.crypto.Cipher;
import ua.abond.homework.math.MyMath;

import java.math.BigInteger;
import java.util.Random;

public class RSACipher implements Cipher {
    private static final int DEFAULT_BIT_LENGTH = 1024;

    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    public RSACipher(KeyPair keyPair) {
        this(keyPair.getPrivateKey(), keyPair.getPublicKey());
    }

    public RSACipher(PrivateKey privateKey, PublicKey publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public byte[] encrypt(byte[] message) {
        return new BigInteger(message).modPow(
                publicKey.getEncryptionExponent(),
                publicKey.getModulus()
        ).toByteArray();
    }

    public byte[] decrypt(byte[] encrypted) {
        return new BigInteger(encrypted).modPow(
                privateKey.getDecryptionExponent(),
                privateKey.getModulus()
        ).toByteArray();
    }

    public static KeyPair generateKeys(int bitLength) {
        Random random = new Random();
        BigInteger q = BigInteger.probablePrime(bitLength, random);
        BigInteger p = BigInteger.probablePrime(bitLength, random);

        BigInteger n = MyMath.karatsuba(q, p);

        BigInteger totient = MyMath.karatsuba(
                p.subtract(BigInteger.ONE),
                q.subtract(BigInteger.ONE)
        );

        BigInteger e = BigInteger.probablePrime(bitLength / 2, random);

        if (e.signum() < 0) {
            e = e.negate();
        }

        BigInteger d = e.modInverse(totient);

        return new KeyPair(
                new PrivateKey(n, d),
                new PublicKey(n, e)
        );
    }

    public static RSACipher create() {
        return new RSACipher(generateKeys(DEFAULT_BIT_LENGTH));
    }

    public static RSACipher create(int bitLength) {
        return new RSACipher(generateKeys(bitLength));
    }
}
