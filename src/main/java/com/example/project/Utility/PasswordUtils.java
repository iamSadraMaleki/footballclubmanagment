package com.example.project.Utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {

    // متد برای هش کردن رمز عبور
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(Integer.toHexString(0xFF & b));
        }
        return hexString.toString();
    }

    // متد برای مقایسه رمز عبور وارد شده با رمز عبور ذخیره شده
    public static boolean checkPassword(String enteredPassword, String storedPasswordHash) throws NoSuchAlgorithmException {
        // هش کردن رمز عبور وارد شده
        String hashedEnteredPassword = hashPassword(enteredPassword);
        // مقایسه هش رمز عبور وارد شده با رمز عبور ذخیره شده
        return hashedEnteredPassword.equals(storedPasswordHash);
    }
}
