package com.anbel.TestBD.controller;

import com.anbel.TestBD.entity.Book;
import com.anbel.TestBD.entity.Users;
import com.anbel.TestBD.service.BookService;
import com.anbel.TestBD.service.UsersService;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UsersService usersService;

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }
    @GetMapping("/addBook")
    public String showAddBookForm(Book book) {
        return "add-book";
    }

    @PostMapping("/addBook")
    public String addBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }
    @GetMapping("/editBook")
    public String editBook(Long id, Model model) {
        Book book = bookService.getBookById(id);
            model.addAttribute("book", book);
            return "edit-Book";
    }
    @PostMapping("/updateBook")
    public String updateBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }
    @PostMapping("/deleteBook")
    public String deleteBook(Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
