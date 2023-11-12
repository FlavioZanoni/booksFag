package com.fag.booksFag;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    
    List<Book> findByStatus(BookStatus status);

    List<Book> findByAuthor(String author);
}