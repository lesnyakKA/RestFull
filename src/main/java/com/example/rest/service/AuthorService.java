package com.example.rest.service;


import com.example.rest.controller.AuthorController;
import com.example.rest.entity.Author;
import com.example.rest.entity.Book;
import com.example.rest.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> findByNameContaining(String name) {
        return authorRepository.findByNameContaining(name);
    }
}
