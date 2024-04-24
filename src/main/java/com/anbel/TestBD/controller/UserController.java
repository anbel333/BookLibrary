package com.anbel.TestBD.controller;

import com.anbel.TestBD.entity.Users;
import com.anbel.TestBD.service.BookService;
import com.anbel.TestBD.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private BookService bookService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", usersService.getAllUsers());
        return "users";
    }
}
