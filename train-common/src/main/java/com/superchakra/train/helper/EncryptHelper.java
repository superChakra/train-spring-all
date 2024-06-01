package com.superchakra.train.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

@Component
public class EncryptHelper {

    private  final int ITERATIONS = 10000; // 迭代次数
    private  final int KEY_LENGTH = 256; // 密钥长度
    private  final int SALT_LENGTH = 16; // 盐的长度

    @Value("${encrypt.salt}")
    private String saltHash;


    // 生成加盐哈希密码（使用自定义盐值）
    public  String hashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt  = saltHash.getBytes();
        byte[] hash = hash(password, salt); // 计算哈希值
        return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(hash);
    }

    // 验证密码
    public  boolean verifyPassword(String password, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String[] parts = storedPassword.split(":");
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] storedHash = Base64.getDecoder().decode(parts[1]);
        byte[] hash = hash(password, salt);
        return slowEquals(storedHash, hash);
    }

    // 计算加盐哈希
    private  byte[] hash(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        return factory.generateSecret(spec).getEncoded();
    }

    // 生成随机盐
    private  byte[] generateSalt() {
        byte[] salt = new byte[SALT_LENGTH];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
        return salt;
    }

    // 比较两个字节数组是否相同
    private  boolean slowEquals(byte[] a, byte[] b) {
        int diff = a.length ^ b.length;
        for (int i = 0; i < a.length && i < b.length; i++) {
            diff |= a[i] ^ b[i];
        }
        return diff == 0;
    }
}
