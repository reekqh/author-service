package com.example.demo.controller;

import com.example.demo.repository.Author;
import com.example.demo.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> findAll(){
        return authorService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Author findById(@PathVariable Long id){
        return authorService.findById(id);
    }

}
