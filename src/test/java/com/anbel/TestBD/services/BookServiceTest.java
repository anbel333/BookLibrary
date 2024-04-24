package com.anbel.TestBD.services;

import com.anbel.TestBD.entity.Book;
import com.anbel.TestBD.repository.BookRepository;
import com.anbel.TestBD.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookService bookService;

    @Test
    public void returnBookTest() {
        Book testBook = new Book();
        testBook.setId(1L);
        when(bookRepository.findById(any(Long.class))).thenReturn(Optional.of(testBook));
        when(bookRepository.save(any(Book.class))).thenReturn(testBook);
        Book book = bookService.returnBook(333L, 1L);
        Assertions.assertEquals(testBook.getId(), book.getId());
        Assertions.assertNotEquals(book.getId(), 2L);
        Assertions.assertNotNull(book);
    }
}
