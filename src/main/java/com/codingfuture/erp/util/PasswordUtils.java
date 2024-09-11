package com.codingfuture.erp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordUtils {

    // 生成盐值
    public static String generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // 对密码进行加盐和哈希处理
    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(Base64.getDecoder().decode(salt));
        byte[] hashedPassword = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    // 校验密码
    public static boolean verifyPassword(String password, String salt, String storedHash) throws NoSuchAlgorithmException {
        String hash = hashPassword(password, salt);
        return hash.equals(storedHash);
    }
}