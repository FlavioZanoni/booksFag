package com.fag.booksFag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // Get all books
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    // Get a book by ID
    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Save a new book
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Update an existing book
    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPageCount(bookDetails.getPageCount());
        book.setAmazonLink(bookDetails.getAmazonLink());
        book.setStatus(bookDetails.getStatus());
        return bookRepository.save(book);
    }

    // Delete a book
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Update reading progress
    public Book updateReadingProgress(Long id, int currentPage) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        if(currentPage > 0 && currentPage <= book.getPageCount()) {
            book.setStatus(BookStatus.READING);
            // Update additional fields if needed, e.g., a field to track current page
        }
        return bookRepository.save(book);
    }
}