package ua.abond.homework.crypto.rsa;

import ua.abond.homework.crypto.util.ErrorHandlingUtil;

import java.math.BigInteger;

public class PublicKey {
    private final BigInteger modulus;
    private final BigInteger encryptionExponent;

    public PublicKey(BigInteger modulus, BigInteger exponent) {
        ErrorHandlingUtil.checkIfNotNull(modulus, "Modulus cannot be null.");
        ErrorHandlingUtil.checkIfNotNull(exponent, "EncryptionExponent cannot be null.");

        this.modulus = modulus;
        this.encryptionExponent = exponent;
    }

    public BigInteger getModulus() {
        return modulus;
    }

    public BigInteger getEncryptionExponent() {
        return encryptionExponent;
    }
}
