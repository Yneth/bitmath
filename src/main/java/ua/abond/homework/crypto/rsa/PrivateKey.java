package ua.abond.homework.crypto.rsa;

import java.math.BigInteger;

public class PrivateKey {
    private final BigInteger modulus;
    private final BigInteger decryptionExponent;

    public PrivateKey(BigInteger modulus, BigInteger exponent) {
        this.modulus = modulus;
        this.decryptionExponent = exponent;
    }

    public BigInteger getModulus() {
        return modulus;
    }

    public BigInteger getDecryptionExponent() {
        return decryptionExponent;
    }
}
