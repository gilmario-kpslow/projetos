package br.com.truesystem.projetosweb.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gilmario
 */
public class CriptografiaUtil {

    public static String MD5(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
            return hash.toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CriptografiaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String SHA1(String senha) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        return hash.toString(16);
    }

//    public static void main(String[] args) throws NoSuchAlgorithmException {
//        System.out.println(MD5("123456"));
//        System.out.println(SHA1("123456"));
//
//        /**
//            * e10adc3949ba59abbe56e057f20f883e *
//         */
//    }
}
