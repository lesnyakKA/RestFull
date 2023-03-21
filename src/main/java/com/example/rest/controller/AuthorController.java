package com.example.rest.controller;


import com.example.rest.entity.Author;
import com.example.rest.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;


    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all")
    public List<Author> findAll () {
        return (List<Author>) authorService.findAllAuthors();
    }

    @GetMapping()
    public List<Author> findByNameContaining(@RequestParam String name) {
        return authorService.findByNameContaining(name);
    }
}
