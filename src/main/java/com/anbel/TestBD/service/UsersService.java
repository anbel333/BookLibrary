package com.anbel.TestBD.service;

import com.anbel.TestBD.entity.Book;
import com.anbel.TestBD.entity.Users;
import com.anbel.TestBD.repository.BookRepository;
import com.anbel.TestBD.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
    public Users saveUsers(Users users) {
        return usersRepository.save(users);
    }
    public Users getUsersById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }
    public Users getUserByEmail(String email) {
        return usersRepository.findByEmail(email).orElse(null);
    }
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
    public List<Book> getUserBooks(Long userId) {
        return bookService.getBooksByUserId(userId);
    }

    public void addBookToUser(Long userId, Book book) {
        Users user = usersRepository.findById(userId).orElse(null);
        List<Book> userBooks = user.getUserBooks();
        userBooks.add(book);
        usersRepository.save(user);
    }
}
