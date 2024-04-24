package com.anbel.TestBD.controller;

import com.anbel.TestBD.entity.Book;
import com.anbel.TestBD.entity.Users;
import com.anbel.TestBD.service.BookService;
import com.anbel.TestBD.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserAccountController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private BookService bookService;

    @GetMapping("/userAccount")
    public String userAccount(Model model) {
        Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String fullName = user.getEmail();
        List<Book> userBook = bookService.getBooksByUserId(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("userBooks", userBook);
        return "userAccount";
    }
    @PostMapping("/returnBook")
    public String returnBook(Long userId, Long bookId) {
        bookService.returnBook(userId, bookId);
        return "redirect:/userAccount?userId=" + userId;
    }
}
