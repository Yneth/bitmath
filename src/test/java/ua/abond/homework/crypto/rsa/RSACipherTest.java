package ua.abond.homework.crypto.rsa;

import org.junit.Test;
import ua.abond.homework.crypto.Cipher;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RSACipherTest {

    @Test(expected = NullPointerException.class)
    public void testConstructorFirstArgNull() throws Exception {
        new RSACipher(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorSecondArgNull() throws Exception {
        KeyPair kp = KeyPair.generateRSAKeys(256);
        new RSACipher(kp.getPrivateKey(), null);
    }

    @Test
    public void testGenerateKeys() {
        KeyPair kp = KeyPair.generateRSAKeys(256);
        PrivateKey privateKey = kp.getPrivateKey();
        PublicKey publicKey = kp.getPublicKey();

        assertTrue(privateKey.getModulus().isProbablePrime(0));
        assertTrue(privateKey.getDecryptionKey().isProbablePrime(0));
        assertTrue(publicKey.getModulus().isProbablePrime(0));
        assertTrue(publicKey.getEncryptionKey().isProbablePrime(0));
        assertTrue(privateKey.getModulus().equals(publicKey.getModulus()));
    }

    @Test
    public void testDecrypt() throws Exception {
        Cipher cipher = new RSACipher(16);
        String message = "Encrypted message";
        byte[] encrypted = cipher.encrypt(message);
        assertEquals(message, cipher.decrypt(encrypted));
    }

    @Test
    public void testDecryptPredefinedCases() {
        BigInteger n = BigInteger.valueOf(3233);
        BigInteger e = BigInteger.valueOf(17);
        BigInteger d = BigInteger.valueOf(2753);

        PublicKey publicKey = new PublicKey(n, e);
        PrivateKey privateKey = new PrivateKey(n, d);
        Cipher cipher = new RSACipher(privateKey, publicKey);

        String message = "2753321321312";
        byte[] encrypted = cipher.encrypt(message);
        byte[] expectedEncryption = {11, 40};
        BigInteger i = new BigInteger(encrypted);
        assertEquals(message, cipher.decrypt(encrypted));
    }

}