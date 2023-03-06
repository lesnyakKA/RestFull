package com.example.rest.service;

import com.example.rest.entity.Book;
import com.example.rest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public List<Book> findByPublicationDate(LocalDate date) {
        return bookRepository.findByPublicationDate(date);
    }

    public Optional<Book> findById(Long id) {
       return bookRepository.findById(id);
    }

    public void addBook(String title) {
        bookRepository.save(new Book(title, LocalDate.now()));
    }
}
