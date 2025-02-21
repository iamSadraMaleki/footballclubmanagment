package com.example.project.users.service;


import com.example.project.Utility.PasswordUtils;
import com.example.project.users.modelENTTI.UsersModel;
import com.example.project.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    // متد برای ثبت نام کاربر
    public UsersModel registerUser(String name, String username, String password, String role , String phoneNumber) throws NoSuchAlgorithmException {
        // هش کردن رمز عبور
        String hashedPassword = PasswordUtils.hashPassword(password);

        // ایجاد کاربر جدید
        UsersModel user = new UsersModel();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(hashedPassword);
        user.setRole(role);// تعیین رول کاربر
        user.setPhoneNumber(phoneNumber);

        // ذخیره کاربر در دیتابیس
        return userRepository.save(user);
    }

    // متد برای پیدا کردن کاربر بر اساس نام کاربری
    public UsersModel findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // متد برای احراز هویت کاربر
    public boolean authenticateUser(String username, String password) throws NoSuchAlgorithmException {
        UsersModel user = userRepository.findByUsername(username); // پیدا کردن کاربر بر اساس نام کاربری
        if (user != null) {
            // مقایسه رمز عبور وارد شده با رمز عبور ذخیره شده در دیتابیس
            return PasswordUtils.checkPassword(password, user.getPassword()); // مقایسه رمز عبور
        }
        return false; // اگر کاربر یافت نشد
    }

    public UsersModel getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

