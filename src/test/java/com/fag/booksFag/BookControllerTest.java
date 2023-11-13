package com.fag.booksFag;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.mockito.ArgumentMatchers.any;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testCreateBook() throws Exception {
        Book book = new Book(Long.valueOf(1), "The Hobbit", "J.R.R. Tolkien", 295, "https://www.amazon.com.br/Hobbit-J-R-Tolkien/dp/0261103342/", 295, BookStatus.READING);
        when(bookService.saveBook(any(Book.class))).thenReturn(book);

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk());
    }


    @Test
    public void testGetAllBooks() throws Exception {
        Book book = new Book(Long.valueOf(1), "The Hobbit", "J.R.R. Tolkien", 295, "https://www.amazon.com.br/Hobbit-J-R-Tolkien/dp/0261103342/", 295, BookStatus.READING);

        when(bookService.findAllBooks()).thenReturn(Arrays.asList(book));

        mockMvc.perform(get("/books"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void testGetBookById() throws Exception {
        Long bookId = 1L;
        Book book = new Book(Long.valueOf(1), "The Hobbit", "J.R.R. Tolkien", 295, "https://www.amazon.com.br/Hobbit-J-R-Tolkien/dp/0261103342/", 295, BookStatus.READING);

        book.setId(bookId);

        when(bookService.findBookById(bookId)).thenReturn(Optional.of(book));

        mockMvc.perform(get("/books/" + bookId))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id", is(bookId.intValue())));
    }

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
}
