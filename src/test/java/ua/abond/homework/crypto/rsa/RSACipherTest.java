package ua.abond.homework.crypto.rsa;

import org.junit.Test;
import ua.abond.homework.crypto.Cipher;

import static org.junit.Assert.*;

public class RSACipherTest {
    @Test
    public void decrypt() throws Exception {
        Cipher cipher = RSACipher.create(128);
        String message = "Encrypted message";
        byte[] encrypted = cipher.encrypt(message.getBytes());
        assertEquals(message, new String(cipher.decrypt(encrypted)));
    }

}