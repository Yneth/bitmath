package ua.abond.homework.crypto;

public interface Cipher {
    byte[] encrypt(String message);
    String decrypt(byte[] encrypted);
}
