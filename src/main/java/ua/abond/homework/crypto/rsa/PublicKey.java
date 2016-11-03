package ua.abond.homework.crypto.rsa;

import ua.abond.homework.crypto.util.ErrorHandlingUtil;

import java.math.BigInteger;

public class PublicKey {
    private final BigInteger modulus;
    private final BigInteger encryptionKey;

    public PublicKey(BigInteger modulus, BigInteger key) {
        ErrorHandlingUtil.checkIfNotNull(modulus, "Modulus cannot be null.");
        ErrorHandlingUtil.checkIfNotNull(key, "EncryptionKey cannot be null.");

        this.modulus = modulus;
        this.encryptionKey = key;
    }

    public BigInteger getModulus() {
        return modulus;
    }

    public BigInteger getEncryptionKey() {
        return encryptionKey;
    }
}
