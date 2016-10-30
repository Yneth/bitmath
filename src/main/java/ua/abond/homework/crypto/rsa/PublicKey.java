package ua.abond.homework.crypto.rsa;

import java.math.BigInteger;

public class PublicKey {
    private final BigInteger modulus;
    private final BigInteger encryptionExponent;

    public PublicKey(BigInteger modulus, BigInteger encryptionExponent) {
        this.modulus = modulus;
        this.encryptionExponent = encryptionExponent;
    }

    public BigInteger getModulus() {
        return modulus;
    }

    public BigInteger getEncryptionExponent() {
        return encryptionExponent;
    }
}
