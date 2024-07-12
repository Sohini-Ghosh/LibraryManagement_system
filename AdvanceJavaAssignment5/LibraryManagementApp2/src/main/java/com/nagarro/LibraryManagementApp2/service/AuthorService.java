package com.nagarro.LibraryManagementApp2.service;

import com.nagarro.LibraryManagementApp2.entities.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AuthorService {
    public void addOrUpdateAuthor(Author author);
    public List<Author> getAuthors();
    public Optional<Author> getAuthor(Integer id);
    public void deleteBook(Integer id);
}
