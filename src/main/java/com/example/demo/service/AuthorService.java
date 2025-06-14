package com.example.demo.service;

import com.example.demo.repository.Author;
import com.example.demo.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService (AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public Author findById(Long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if(optionalAuthor.isPresent()){
            return optionalAuthor.get();
        } else {
            throw new IllegalStateException("Author with ID: "+ id +" does not exists.");
        }
    }

    public void save(Author author) {
        authorRepository.save(author);
    }

    public void delete(Long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()){
            authorRepository.delete(optionalAuthor.get());
        } else {
            throw new IllegalStateException("Author with ID: "+ id +" does not exists.");
        }
    }

    @Transactional
    public void update(Long id, String name, LocalDate dateOfBirth, String bio) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isEmpty()){
            throw new IllegalStateException("Author with ID: "+ id +" does not exists.");
        }

        Author author = optionalAuthor.get();
        if(name != null && !name.isBlank() && !name.equals(author.getName())){
            author.setName(name);
        }
        if(dateOfBirth != null && !dateOfBirth.equals(author.getDateOfBirth())){
            author.setDateOfBirth(dateOfBirth);
        }
        if(bio != null && !bio.isBlank() && !bio.equals(author.getBio())){
            author.setBio(bio);
        }
    }
}
