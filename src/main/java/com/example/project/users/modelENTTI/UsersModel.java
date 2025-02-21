package com.example.project.users.modelENTTI;

import jakarta.persistence.*;

@Entity
public class UsersModel {  // تغییر نام کلاس به UserEntity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // نام کاربر
    private String username;  // نام کاربری
    private String password;  // پسورد هش شده
    private String role;  // رول کاربر (به‌صورت رشته)

    private String phoneNumber;

    public UsersModel() {
    }
    public UsersModel(String name, String username, String password, String role,String phoneNumber) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.phoneNumber = phoneNumber;
    }



    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addAttribute(String user, UsersModel user1) {
    }
}

