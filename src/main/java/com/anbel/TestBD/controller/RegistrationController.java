package com.anbel.TestBD.controller;

import com.anbel.TestBD.entity.Users;
import com.anbel.TestBD.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class RegistrationController {
    @Autowired
    private  RegistrationService registrationService;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registration";
    }
    @PostMapping("/register")
    public String registerUser(@RequestParam String email,@RequestParam String password) {
        registrationService.registerUser(email,password);
        return "redirect:/login";
    }
}
