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
 * @author Veena SK
 */
public class Decrypt {
    Cipher dcipher;

public Decrypt(SecretKey key) {
try {
dcipher = Cipher.getInstance("DES");
dcipher.init(Cipher.DECRYPT_MODE, key);
 
} 
catch (javax.crypto.NoSuchPaddingException | java.security.NoSuchAlgorithmException | java.security.InvalidKeyException e) 
{
}
}
 public String decrypt(String str) throws IllegalBlockSizeException {
try {
// Decode base64 to get bytes
byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
 
// Decrypt
byte[] utf8 = dcipher.doFinal(dec);
 
// Decode using utf-8
return new String(utf8, "UTF8");
} catch (javax.crypto.BadPaddingException | IllegalBlockSizeException e) {
} catch (UnsupportedEncodingException e) {
} catch (java.io.IOException e) {
}
return null;
}   
    
}
