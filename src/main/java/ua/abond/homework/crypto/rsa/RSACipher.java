package ua.abond.homework.crypto.rsa;

import ua.abond.homework.crypto.Cipher;
import ua.abond.homework.crypto.util.ErrorHandlingUtil;

import java.math.BigInteger;

public class RSACipher implements Cipher {
    private static final int DEFAULT_BIT_LENGTH = 1024;

    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    public RSACipher() {
        this(DEFAULT_BIT_LENGTH);
    }

    public RSACipher(int bitLength) {
        this(KeyPair.generateRSAKeys(bitLength));
    }

    public RSACipher(KeyPair keyPair) {
        this(keyPair.getPrivateKey(), keyPair.getPublicKey());
    }

    public RSACipher(PrivateKey privateKey, PublicKey publicKey) {
        ErrorHandlingUtil.checkIfNotNull(privateKey, "PrivateKey cannot be null.");
        ErrorHandlingUtil.checkIfNotNull(publicKey, "PublicKey cannot be null.");

        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    @Override
    public byte[] encrypt(String message) {
        BigInteger msg = new BigInteger(message.getBytes());

        if (msg.compareTo(publicKey.getModulus()) >= 0) {
            throw new IllegalArgumentException("Passed message is too big.");
        }

        return new BigInteger(message.getBytes()).modPow(
                publicKey.getEncryptionKey(),
                publicKey.getModulus()
        ).toByteArray();
    }

    @Override
    public String decrypt(byte[] encrypted) {
        BigInteger encryptedMsg = new BigInteger(encrypted);

        if (encryptedMsg.compareTo(publicKey.getModulus()) >= 0) {
            throw new IllegalArgumentException("Passed message is too big.");
        }

        return new String(new BigInteger(encrypted).modPow(
                privateKey.getDecryptionKey(),
                privateKey.getModulus()
        ).toByteArray());
    }
}
