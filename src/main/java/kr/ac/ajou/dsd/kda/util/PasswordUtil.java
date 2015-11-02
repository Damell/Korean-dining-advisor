package kr.ac.ajou.dsd.kda.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.xml.bind.DatatypeConverter;

import kr.ac.ajou.dsd.kda.model.User;

//taken from http://armoredbarista.blogspot.kr/2013/07/safely-create-and-store-passwords.html
public class PasswordUtil {
	
    public static final String HASH_ALGORITHM = "SHA-256"; 
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private static final char[] PASSWORD_CHARS = new char[]{
        '!', '@', '#', '$', '%', '&', '*', '(', ')', 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static String getRandomString(final int length) {
         
        SecureRandom secureRandom = new SecureRandom(); 
        StringBuilder sb = new StringBuilder(length);
        int position = 0;
      
        for (int i = 0; i < length; i++ ) {
            position = secureRandom.nextInt(PASSWORD_CHARS.length);
            sb.append(PASSWORD_CHARS[position]);
        }
        return sb.toString();
    }

    public static byte[] createPasswordHash(final String password,
            final String salt) {
        byte[] result = null;
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            digest.update(salt.getBytes(DEFAULT_CHARSET));
            digest.update(password.getBytes(DEFAULT_CHARSET));
            result = digest.digest();
        } catch (NoSuchAlgorithmException e) {
            // TODO Logging
        }

        return result;
    }

    public static boolean checkPassword(final String hashedPassword, final String salt, final String password) {
        boolean result = false;
        byte[] checkPasswordHashBytes = createPasswordHash(password, salt);
        String checkPasswordHash = DatatypeConverter.printBase64Binary(checkPasswordHashBytes); 

        if (checkPasswordHash != null && hashedPassword != null
                && checkPasswordHash.equals(hashedPassword)) {
            result = true;
        }

        return result;
    }

}
