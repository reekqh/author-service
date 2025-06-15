package com.example.demo.controller;

import com.example.demo.repository.Book;
import com.example.demo.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/books")
public class BookController {

    private final BookService bookService;

    public BookController (BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }
}
