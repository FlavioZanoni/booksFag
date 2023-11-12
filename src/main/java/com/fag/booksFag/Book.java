package com.fag.booksFag;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 100)
    private String author;

    @Column(nullable = false)
    private int pageCount;

    @Column(length = 200)
    private String amazonLink;

    @Column(nullable = false)
    private int currentPage = 0;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookStatus status;

}
