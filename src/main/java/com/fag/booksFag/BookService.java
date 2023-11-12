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
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
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
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        if(currentPage > 0 && currentPage <= book.getPageCount()) {
            book.setStatus(BookStatus.READING);
        }
        return bookRepository.save(book);
    }

    // Update book status
    public Book updateBookStatus(Long id, BookStatus status) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        book.setStatus(status).orElseThrow(() -> new RuntimeException("Status invalido"));
        return bookRepository.save(book);
    }
}