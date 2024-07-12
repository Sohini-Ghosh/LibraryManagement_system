package com.nagarro.LibraryManagementApp2.repository;

import com.nagarro.LibraryManagementApp2.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
