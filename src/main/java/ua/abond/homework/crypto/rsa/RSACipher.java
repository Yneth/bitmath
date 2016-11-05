package ua.abond.homework.crypto.rsa;

import ua.abond.homework.crypto.Cipher;
import ua.abond.homework.crypto.util.ErrorHandlingUtil;

import java.math.BigInteger;

public class RSACipher implements Cipher {
    private static final int DEFAULT_BIT_LENGTH = 1024;

    private final PrivateKey privateKey;
    private final PublicKey publicKey;

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
        checkMessage(privateKey.getModulus(), msg);

        return msg.modPow(
                publicKey.getEncryptionKey(),
                publicKey.getModulus()
        ).toByteArray();
    }

    @Override
    public String decrypt(byte[] encrypted) {
        BigInteger encryptedMsg = new BigInteger(encrypted);
        checkMessage(privateKey.getModulus(), encryptedMsg);

        return new String(encryptedMsg.modPow(
                privateKey.getDecryptionKey(),
                privateKey.getModulus()
        ).toByteArray());
    }

    private void checkMessage(BigInteger modulus, BigInteger message) {
        if (message.compareTo(modulus) >= 0) {
            throw new IllegalArgumentException("Passed message is too big.");
        }
    }

    public static Cipher create() {
        return create(DEFAULT_BIT_LENGTH);
    }

    public static Cipher create(int bitLength) {
        KeyPair kp = KeyPair.generateRSAKeys(bitLength);
        return new RSACipher(kp.getPrivateKey(), kp.getPublicKey());
    }
}
