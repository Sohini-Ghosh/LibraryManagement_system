package com.nagarro.LibraryManagementApp2.controller;

import com.nagarro.LibraryManagementApp2.entities.Author;
import com.nagarro.LibraryManagementApp2.entities.Book;
import com.nagarro.LibraryManagementApp2.repository.AuthorRepo;
import com.nagarro.LibraryManagementApp2.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    @Autowired
    AuthorService as;

    @PostMapping(path = "/authors")
    public void addAuthors(@RequestBody Author author) {
        as.addOrUpdateAuthor(author);
    }

    @PutMapping(path = "/authors")
    public void saveOrUpdateAuthors(@RequestBody Author author) {
        as.addOrUpdateAuthor(author);
    }

    @GetMapping(path = "/authors")
    public List<Author> getAuthors() {
        return as.getAuthors();
    }


    @RequestMapping("/authors/{id}")
    public Optional<Author> getAuthor(@PathVariable("id") Integer id) {
        return as.getAuthor(id);
    }

    @DeleteMapping("/authors/{id}")
    public void deleteBook(@PathVariable("id") Integer id) {
        as.deleteBook(id);
    }
}
