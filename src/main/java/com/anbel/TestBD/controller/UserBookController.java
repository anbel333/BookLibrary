package com.anbel.TestBD.controller;

import com.anbel.TestBD.entity.Book;
import com.anbel.TestBD.entity.Users;
import com.anbel.TestBD.service.BookService;
import com.anbel.TestBD.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserBookController {
    @Autowired
    public UsersService usersService;
    @Autowired
    public BookService bookService;
    @GetMapping("/userBooks")
    public String getUserBooks(Long userId, Model model) {
        List<Book> userBooks = usersService.getUserBooks(userId);
        model.addAttribute("userBooks", userBooks);

        Users users = usersService.getUsersById(userId);
        String usersName = users.getFullName();
        model.addAttribute("userName", usersName);
        return "userBooks";
    }
    @PostMapping("/addBookToUsers")
    public String addBookToUsers(Long userId, Book book) {
        Users users = usersService.getUsersById(userId);
        book.setUsers(users);
        book.setTakenByUser(true);
        bookService.saveBook(book);
        return "redirect:/userAccount?userId=" + userId;
    }
}
