package com.anbel.TestBD.repository;

import com.anbel.TestBD.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByUsersId(Long userId);

    List<Book> findByTakenByUser(boolean takenByUser);
}