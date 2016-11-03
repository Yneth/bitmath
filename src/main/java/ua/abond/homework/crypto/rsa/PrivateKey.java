package ua.abond.homework.crypto.rsa;

import ua.abond.homework.crypto.util.ErrorHandlingUtil;

import java.math.BigInteger;

public class PrivateKey {
    private final BigInteger modulus;
    private final BigInteger decryptionKey;

    public PrivateKey(BigInteger modulus, BigInteger key) {
        ErrorHandlingUtil.checkIfNotNull(modulus, "Modulus cannot be null.");
        ErrorHandlingUtil.checkIfNotNull(key, "DecryptionKey cannot be null.");

        this.modulus = modulus;
        this.decryptionKey = key;
    }

    public BigInteger getModulus() {
        return modulus;
    }

    public BigInteger getDecryptionKey() {
        return decryptionKey;
    }
}
