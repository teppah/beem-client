package com.yfy.beem.client.crypto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyException;
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

    /**
     * Decrypt using
     * */
    @Override
    public String encrypt(String original) {
        try {
            Cipher cipher  = Cipher.getInstance(RSA);
            log.info("cipher = ", cipher);
            cipher.init(Cipher.ENCRYPT_MODE,publicKey);
            byte[] encrypted = cipher.doFinal(original.getBytes());
            return new String(encrypted);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
            log.info("error: {}", e);
        } catch (InvalidKeyException e) {
            log.info("invalid key: {}", e);
        }  catch (GeneralSecurityException e) {
            log.info("security exception: {}", e);
        }
        return null;
    }

    @Override
    public String decrypt(String encrypted) {
        try {
            Cipher cipher = Cipher.getInstance(RSA);
            cipher.init(Cipher.DECRYPT_MODE,privateKey);
            byte[] decrypted = cipher.doFinal(encrypted.getBytes());
            return new String(decrypted);
        } catch (GeneralSecurityException e) {
            log.info("security exception: {}", e);
        }
        return null;
    }
}
