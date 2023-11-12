package com.fag.booksFag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    // Get a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.findBookById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new book
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    // Update a book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    // Delete a book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

    // Update reading progress
    @PatchMapping("/{id}/progress/{currentPage}")
    public ResponseEntity<Book> updateReadingProgress(@PathVariable Long id, @PathVariable int currentPage) {
        return ResponseEntity.ok(bookService.updateReadingProgress(id, currentPage));
    }

    // Update book status
    @PatchMapping("/{id}/status/{status}")
    public ResponseEntity<Book> updateBookStatus(@PathVariable Long id, @PathVariable BookStatus status) {
        return ResponseEntity.ok(bookService.updateBookStatus(id, status));
    }

    // Get books by status
    @GetMapping("/status/{status}")
    public List<Book> getBooksByStatus(@PathVariable BookStatus status) {
        return bookService.findBooksByStatus(status);
    }

    // Get books by author
    @GetMapping("/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.findBooksByAuthor(author);
    }
}