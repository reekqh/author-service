package com.example.demo.controller;

import com.example.demo.repository.Author;
import com.example.demo.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @PostMapping
    public void addAuthor(@RequestBody Author author){
        authorService.save(author);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAuthor(@PathVariable Long id){
        authorService.delete(id);
    }

    @PutMapping(path = "/{id}")
    public void updateAuthor(@PathVariable Long id,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) LocalDate dateOfBirth,
                             @RequestParam(required = false) String bio){
        authorService.update(id, name, dateOfBirth, bio);
    }

}
