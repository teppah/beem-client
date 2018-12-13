package com.yfy.beem.client.crypto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * Class that encrypts and decrypts String messages based on an RSA keypair
 */
@AllArgsConstructor
@Getter
@Slf4j
public class RSACryptographyService
        implements CryptographyService {
    private final String RSA = "RSA/ECB/PKCS1Padding";
    private final RSAPublicKey publicKey;
    private final RSAPrivateKey privateKey;


    @Override
    public String encrypt(String original) {
        try {
            Cipher cipher  = Cipher.getInstance(RSA);
            cipher.init(Cipher.ENCRYPT_MODE,publicKey);
            byte[] encrypted = cipher.doFinal(original.getBytes());
            return new String(encrypted);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
            log.info("error: {}", e);
        } catch (InvalidKeyException e) {

        } catch (Exception e) {

        }
    }

    @Override
    public String decrypt(String encrypted) {
        return null;
    }
}
