package AES256;

import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;


public class Aes256 {
	
	
	public static void main(String[] args) throws Exception{
		String str = "김나리";
		Aes256 app = new Aes256();
		str = app.encrypt(str);
		System.out.println("str: "+str);
		str = app.decrypt(str);
		System.out.println("str: "+str);
		
		
	}
	

	
	private static final int keySize = 256;
    private static final int iterationCount = 10000;//암호화 키 생성 횟수
    private static String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";//AES256 기준 64자리 16진수
    private static String iv = "F27D5C9927726BCEFE7510B1BDD3D137";//AES256 기준 32자리 16진수
    private static final String passPhrase = "KNUHAPI";
    
    private final Cipher cipher;
    
    
    public Aes256() throws Exception {
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    
    public String encrypt(String plaintext) throws Exception {
        return encrypt(salt, iv, passPhrase, plaintext);
    }
    
    
    public String decrypt(String ciphertext) throws Exception {
        return decrypt(salt, iv, passPhrase, ciphertext);
    }
    
    
    private String encrypt(String salt, String iv, String passPhrase, String plaintext) throws Exception {
        SecretKey key = generateKey(salt, passPhrase);        
        byte[] encrypted = doFinal(Cipher.ENCRYPT_MODE, key, iv, plaintext.getBytes("UTF-8"));        
        return encodeBase64(encrypted);
    	
    }

    
    private String decrypt(String salt, String iv, String passPhrase, String ciphertext) throws Exception {    	
        SecretKey key = generateKey(salt, passPhrase);        
        byte[] decrypted = doFinal(Cipher.DECRYPT_MODE, key, iv, decodeBase64(ciphertext));
        
        return new String(decrypted, "UTF-8");
    }

    
    private byte[] doFinal(int encryptMode, SecretKey key, String iv, byte[] bytes) throws Exception {
        cipher.init(encryptMode, key, new IvParameterSpec(decodeHex(iv)));
        return cipher.doFinal(bytes);
    }

    
    private SecretKey generateKey(String salt, String passPhrase) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(passPhrase.toCharArray(), decodeHex(salt), iterationCount, keySize);
        SecretKey key = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
        return key;
    }
    
    
    private static String encodeBase64(byte[] bytes) {
    	byte[] encodeByte = Base64.encodeBase64(bytes);    	
        return Base64.encodeBase64String(encodeByte);
    }

    
    private static byte[] decodeBase64(String str) {
    	byte[] decodeByte = Base64.decodeBase64(str);
        return Base64.decodeBase64(decodeByte);
    }

    
    private static String encodeHex(byte[] bytes) {
        return Hex.encodeHexString(bytes);
    }

    
    private static byte[] decodeHex(String str) throws Exception {
        return Hex.decodeHex(str.toCharArray());
    }
    
    
   /* private static String getRandomHexString(int length) {//length 만큼의 16진수 문자열 생성기
        byte[] salt = new byte[length];
        new SecureRandom().nextBytes(salt);
        return encodeHex(salt);

    }*/
}
