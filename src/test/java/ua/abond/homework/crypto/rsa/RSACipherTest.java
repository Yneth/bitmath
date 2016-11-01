package ua.abond.homework.crypto.rsa;

import org.junit.Test;
import ua.abond.homework.crypto.Cipher;

import java.security.*;

import static org.junit.Assert.*;

public class RSACipherTest {

    @Test(expected = NullPointerException.class)
    public void testConstructorFirstArgNull() throws Exception {
        new RSACipher(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorSecondArgNull() throws Exception {
        KeyPair kp = RSACipher.generateKeys(256);
        new RSACipher(kp.getPrivateKey(), null);
    }

    @Test
    public void testDecrypt() throws Exception {
        Cipher cipher = RSACipher.create(128);
        String message = "Encrypted message";
        byte[] encrypted = cipher.encrypt(message.getBytes());
        assertEquals(message, new String(cipher.decrypt(encrypted)));
    }

    @Test
    public void testGenerateKeys() {
        KeyPair kp = RSACipher.generateKeys(256);
        PrivateKey privateKey = kp.getPrivateKey();
        PublicKey publicKey = kp.getPublicKey();

        assertTrue(privateKey.getModulus().equals(publicKey.getModulus()));
    }
}