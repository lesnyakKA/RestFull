package com.example.rest.controller;

import com.example.rest.entity.Book;
import com.example.rest.exception.BookNotFoundException;
import com.example.rest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value="/all")
    List<Book> getAll(){
        return bookService.getAllBooks();
    }

    @GetMapping(value="/{id}")
    ResponseEntity<Book> getById(@PathVariable("id") Long id) {
        Book book = bookService.findById(id)
                .orElseThrow(()->new BookNotFoundException("No Book with ID : "+id));
        return ResponseEntity.ok().body(book);
    }

    @PostMapping("/date")
    public List<Book> getByLocalDate(@RequestParam("publicationDate")
                                     @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return bookService.findByPublicationDate(date);
    }

    @PostMapping("/addBook")
    public void addBook(String title) {
        bookService.addBook(title);
    }
}
