package com.example.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private Author author;

    @Column(name="publication_date")
    private LocalDate publicationDate;

    private BigDecimal price;

    public Book() {
    }

    public Book(String title, LocalDate publicationDate, BigDecimal price) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.price = price;
    }

    public Book(Long id, String title, LocalDate publicationDate) {
        this.id = id;
        this.title = title;
        this.publicationDate = publicationDate;
    }

    public Book(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}