package com.example.rest.repository;


import com.example.rest.entity.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    @EntityGraph(attributePaths = {"books"})
    List<Author> findByNameContaining(String name);

}

