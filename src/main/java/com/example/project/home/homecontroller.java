package com.example.project.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homecontroller {

    @GetMapping("/home")
    public String home() {
        return "home"; // home.html رو نشون بده
    }
    @GetMapping("/about")
    public String about() {
        return "aboutSystem"; // aboutSystem.html رو نشون بده
    }
    @GetMapping("/transfer")
    public String transfer() {
        return "transfermainpage"; //
    }
    @GetMapping("/list")
    public String list() {
        return "listmenu"; //
    }
}