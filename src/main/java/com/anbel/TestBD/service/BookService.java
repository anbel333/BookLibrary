package com.anbel.TestBD.service;

import com.anbel.TestBD.entity.Book;
import com.anbel.TestBD.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;
    @Transactional
    public void saveBook(Book book) {
        bookRepository.save(book);
    }
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    public List<Book> getAllBooks() {
        return bookRepository.findByTakenByUser(false);
    }
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    public void saveAll(List<Book> book) {
        bookRepository.saveAll(book);
    }
    public List<Book> getBooksByUserId(Long userId) {
        return bookRepository.findByUsersId(userId);
    }
    public Book returnBook(Long userId, Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        book.setUsers(null);
        book.setTakenByUser(false);
        return bookRepository.save(book);
    }
}
