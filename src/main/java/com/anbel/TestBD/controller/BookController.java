package com.anbel.TestBD.controller;

import com.anbel.TestBD.entity.Book;
import com.anbel.TestBD.entity.Users;
import com.anbel.TestBD.service.BookService;
import com.anbel.TestBD.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@Api("Контроллер для отображения главной страницы с книгами")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UsersService usersService;

    @GetMapping("/books")
    @ApiOperation("Главная страница с книгами")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }
    @GetMapping("/addBook")
    @ApiOperation("Форма для добавления книги")
    public String showAddBookForm(Book book) {
        return "add-book";
    }

    @PostMapping("/addBook")
    @ApiOperation("Добавление книги")
    public String addBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }
    @GetMapping("/editBook")
    @ApiOperation("Форма редактирования книги")
    public String editBook(Long id, Model model) {
        Book book = bookService.getBookById(id);
            model.addAttribute("book", book);
            return "edit-Book";
    }
    @PostMapping("/updateBook")
    @ApiOperation("Редактирование книги")
    public String updateBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }
    @PostMapping("/deleteBook")
    @ApiOperation("Удаление книги")
    public String deleteBook(Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
