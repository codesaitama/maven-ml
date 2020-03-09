//package com.codesaitma.maventest.ciphers;
//
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.KeyGenerator;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.SecretKey;
//import javax.xml.bind.DatatypeConverter;
//
//public class AESEncryption {
//
//    public static void main(String[] args) throws Exception {
//        String plainText = "Hello World";
//        SecretKey secKey = getSecretEncryptionKey();
//        byte[] cipherText = encryptText(plainText, secKey);
//        String decryptedText = decryptText(cipherText, secKey);
//
//        System.out.println("Original Text:" + plainText);
//        System.out.println("AES Key (Hex Form):" + bytesToHex(secKey.getEncoded()));
//        System.out.println("Encrypted Text (Hex Form):" + bytesToHex(cipherText));
//        System.out.println("Descrypted Text:" + decryptedText);
//
//    }
//
//    /**
//     * gets the AES encryption key. In your actual programs, this should be safely
//     * stored.
//     *
//     * @return secKey (Secret key that we encrypt using it)
//     * @throws NoSuchAlgorithmException
//     *             (from KeyGenrator)
//     *
//     */
//    public static SecretKey getSecretEncryptionKey() throws NoSuchAlgorithmException {
//        KeyGenerator aesKeyGenerator = KeyGenerator.getInstance("AES");
//        aesKeyGenerator.init(128); // The AES key size in number of bits
//        SecretKey secKey = aesKeyGenerator.generateKey();
//        return secKey;
//    }
//
//    public static byte[] encryptText(String plainText, SecretKey secKey) throws NoSuchAlgorithmException,
//            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
//        // AES defaults to AES/ECB/PKCS5Padding in Java 7
//        Cipher aesCipher = Cipher.getInstance("AES");
//        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
//        byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
//        return byteCipherText;
//    }
//
//    public static String decryptText(byte[] byteCipherText, SecretKey secKey) throws NoSuchAlgorithmException,
//            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
//        // AES defaults to AES/ECB/PKCS5Padding in Java 7
//        Cipher aesCipher = Cipher.getInstance("AES");
//        aesCipher.init(Cipher.DECRYPT_MODE, secKey);
//        byte[] bytePlainText = aesCipher.doFinal(byteCipherText);
//        return new String(bytePlainText);
//    }
//
//    private static String bytesToHex(byte[] hash) {
//        return DatatypeConverter.printHexBinary(hash);
//    }
//}
//
