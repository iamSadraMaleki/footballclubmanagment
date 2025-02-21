package com.example.project.users.controller;

import com.example.project.users.modelENTTI.UsersModel;
import com.example.project.users.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UsersModel());
        return "register";
    }

    @PostMapping("/register")
    public ResponseEntity<UsersModel> registerUser(@RequestBody UserRequest userRequest) {
        try {
            UsersModel registeredUser = userService.registerUser(
                    userRequest.getName(),
                    userRequest.getUsername(),
                    userRequest.getPassword(),
                    userRequest.getRole(),
                    userRequest.getPhoneNumber()
            );
            return ResponseEntity.ok(registeredUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserRequest userRequest) {
        try {
            if (userService.authenticateUser(userRequest.getUsername(), userRequest.getPassword())) {
                UsersModel user = userService.findByUsername(userRequest.getUsername());
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("نام کاربری یا رمز عبور اشتباه است.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // یا log کردن exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("خطا در برقراری ارتباط با سرور.");
        }
    }
};

class UserRequest {
    private String name;
    private String username;
    private String password;
    private String role;

    private String phoneNumber;



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
}