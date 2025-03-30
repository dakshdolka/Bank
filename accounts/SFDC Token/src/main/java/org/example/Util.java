package org.example;

import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Optional;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Util {

    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final byte[] keyValue = new byte[] { 'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' }; // 16 bytes Key => 128 bits => AES-128 Algorithm

    public Map<String, String> decryptToken(String token) {
        Map<String, String> requestParamMap = new java.util.HashMap<String, String>();
        if(token == null || token.isEmpty()) {
            return requestParamMap;
        }
        return requestParamMap;
    }

    public String encrypt(String queryString) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        AlgorithmParameters algoParams = AlgorithmParameters.getInstance("AES");
        // Create a random IV everytime
        IvParameterSpec iVPS = createIV(cipher.getBlockSize(), Optional.empty());
        algoParams.init(iVPS);
        cipher.init(Cipher.ENCRYPT_MODE, key, algoParams);
        byte[] encVal = cipher.doFinal(queryString.getBytes());
        return addIv(byteToHex(iVPS.getIV()), byteToHex(encVal));
    }

    private Key generateKey() {
        return new SecretKeySpec(keyValue, "AES");
    }

    private IvParameterSpec createIV(final int ivSizeBytes, final Optional<SecureRandom> rng) {
        final byte[] iv = new byte[ivSizeBytes];
        final SecureRandom theRNG = rng.orElse(new SecureRandom());
        theRNG.nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public String decrypt(String encryptedData) throws Exception {
        // IV is prepended to the encrypted data. Extract the IV and encrypted data.
        String  ivString = encryptedData.substring(0, 32);
	    String cipherText = encryptedData.substring(32);
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        AlgorithmParameters algoParams = AlgorithmParameters.getInstance("AES");
        IvParameterSpec iVPS = new IvParameterSpec(hexStringToByteArray(ivString));
        algoParams.init(iVPS);
        cipher.init(Cipher.DECRYPT_MODE, key, algoParams);
        byte[] decVal = cipher.doFinal(hexStringToByteArray(cipherText));
        return new String(decVal);
    }

    private byte[] hexStringToByteArray(String s) {
        int len = s.length();
        if((len & 1) != 0) return null;
        if(!s.matches("^[a-fA-F0-9]+$")) return null;
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    // Convert a byte array into Hexa Decimal Format
    private String byteToHex(byte[] byteArray) {
        String hex = "";
        for (byte i : byteArray) {
            hex += String.format("%02X", i);
        }
        return hex;
    }

    private String addIv(String iv, String encrypted) {
        // IV is needed at the time of decryption. Usualy practice is to prepend the IV to the encrypted data
        return iv + encrypted;
    }
    
}