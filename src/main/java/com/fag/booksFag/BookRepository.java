package com.fag.booksFag;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Example: Find books by status
    List<Book> findByStatus(BookStatus status);

    // Example: Find books by author
    List<Book> findByAuthor(String author);
}