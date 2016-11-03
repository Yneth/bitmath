package ua.abond.homework.crypto.rsa;

import ua.abond.homework.crypto.util.ErrorHandlingUtil;
import ua.abond.homework.math.BitMath;
import ua.abond.homework.math.Karatsuba;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class KeyPair {
    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    public KeyPair(PrivateKey privateKey, PublicKey publicKey) {
        ErrorHandlingUtil.checkIfNotNull(privateKey, "PrivateKey cannot be null.");
        ErrorHandlingUtil.checkIfNotNull(publicKey, "PublicKey cannot be null.");

        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public static KeyPair generateRSAKeys(int bitLength) {
        Random random = new SecureRandom();
        BigInteger q = BigInteger.probablePrime(bitLength, random);
        BigInteger p = BigInteger.probablePrime(bitLength, random);
        BigInteger phi = Karatsuba.multiply(
                p.subtract(BigInteger.ONE),
                q.subtract(BigInteger.ONE)
        );

        BigInteger modulus = Karatsuba.multiply(p, q);
        BigInteger publicKey = BigInteger.probablePrime(bitLength >> 1, random);
        BigInteger privateKey = publicKey.modInverse(phi);

        return new KeyPair(
                new PrivateKey(modulus, privateKey),
                new PublicKey(modulus, publicKey)
        );
    }
}
