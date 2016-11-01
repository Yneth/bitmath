package ua.abond.homework.crypto.rsa;

import ua.abond.homework.crypto.util.ErrorHandlingUtil;

import java.math.BigInteger;

public class PrivateKey {
    private final BigInteger modulus;
    private final BigInteger decryptionExponent;

    public PrivateKey(BigInteger modulus, BigInteger exponent) {
        ErrorHandlingUtil.checkIfNotNull(modulus, "Modulus cannot be null.");
        ErrorHandlingUtil.checkIfNotNull(exponent, "DecryptionExponent cannot be null.");

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
