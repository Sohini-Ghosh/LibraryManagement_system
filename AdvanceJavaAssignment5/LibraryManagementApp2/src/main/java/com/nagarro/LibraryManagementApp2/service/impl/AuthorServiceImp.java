package com.nagarro.LibraryManagementApp2.service.impl;

import com.nagarro.LibraryManagementApp2.entities.Author;
import com.nagarro.LibraryManagementApp2.repository.AuthorRepo;
import com.nagarro.LibraryManagementApp2.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
@Component
public class AuthorServiceImp implements AuthorService {
    @Autowired
    AuthorRepo repo;

    public void addOrUpdateAuthor(Author author) {
        repo.save(author);
    }

    public List<Author> getAuthors() {
        return repo.findAll();
    }

    public Optional<Author> getAuthor(Integer id) {
        return repo.findById(id);
    }

    public void deleteBook(Integer id) {
        Author author = repo.getById(id);
        repo.delete(author);
    }
}
