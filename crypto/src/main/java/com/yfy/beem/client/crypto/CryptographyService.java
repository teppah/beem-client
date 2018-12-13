package com.yfy.beem.client.crypto;


/**
 * General interface for encrypting and decrypting messages that will either be sent or received
 * */

public interface CryptographyService {
    String encrypt(String original);
    String decrypt(String encrypted);
}
