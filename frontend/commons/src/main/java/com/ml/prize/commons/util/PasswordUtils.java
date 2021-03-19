package com.ml.prize.commons.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author Mr.ml
 * @date 2021/3/18
 */
public class PasswordUtils {

    private String md5(String inputStr) {
        BigInteger bigInteger = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] inputData = inputStr.getBytes();
            messageDigest.update(inputData);
            bigInteger = new BigInteger(messageDigest.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigInteger.toString(16);
    }

    public static String encodePassword(String password) {
        return new PasswordUtils().md5(password);
    }

}
