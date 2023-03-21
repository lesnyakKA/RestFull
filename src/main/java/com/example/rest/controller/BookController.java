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
import java.util.Optional;

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

    @GetMapping("/date")
    List<Book> getByLocalDate(@RequestParam("date")
                                     @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return bookService.findByPublicationDate(date);
    }

    @PostMapping("/addBook")
    void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping("/title")
    List<Book> getByTitle(@RequestParam("title") String title) {
        return bookService.findByTitleContaining(title);
    }

    @PutMapping("/update")
    void updateById(@RequestParam("id") Long id, @RequestParam("title") String newTitle) {
        bookService.updateBookById(id, newTitle);
    }

    @DeleteMapping("/delete")
    void deleteById(@RequestParam("id") Long id) {
        bookService.deleteById(id);
    }
}
