package com.example.rest.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import com.example.rest.entity.Book;
import com.example.rest.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(BookController.class)
public class BookControllerTest {
    @MockBean
    BookService bookService;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testfindAll() throws Exception {
        Book book = new Book(1L, "Re", LocalDate.now());
        List<Book> books = Collections.singletonList(book);

        when(bookService.getAllBooks()).thenReturn(books);

        mockMvc.perform(get("/books/all"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].title", Matchers.is("Re")));
    }

//    @Test
//    public void createBook() throws Exception {
//        Book book = new Book(1L, "Re", LocalDate.now());
//
//
////        when(bookService.addBook().thenReturn(book);
//
//
//        mockMvc.perform(post("/books/addBook"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", Matchers.hasSize(1)))
//                .andExpect(jsonPath("$[0].title", Matchers.is("Re")));
//    }
}
