/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihub.services;

import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;

/**
 *
 * @author Veena SKs
 */
public class Encrypt {
    Cipher ecipher;

 
public Encrypt(SecretKey key) {
try {
ecipher = Cipher.getInstance("DES");

ecipher.init(Cipher.ENCRYPT_MODE, key);

} catch (javax.crypto.NoSuchPaddingException e) {
} catch (java.security.NoSuchAlgorithmException e) {
} catch (java.security.InvalidKeyException e) {
}
}
 
public String encrypt(String str) throws IllegalBlockSizeException {
try {
// Encode the string into bytes using utf-8
byte[] utf8 = str.getBytes("UTF8");
 
// Encrypt
byte[] enc = ecipher.doFinal(utf8);
 
// Encode bytes to base64 to get a string
return new sun.misc.BASE64Encoder().encode(enc);
} catch (javax.crypto.BadPaddingException e) {
} catch (IllegalBlockSizeException e) {
} catch (UnsupportedEncodingException e) {
} 
return null;
}
}
