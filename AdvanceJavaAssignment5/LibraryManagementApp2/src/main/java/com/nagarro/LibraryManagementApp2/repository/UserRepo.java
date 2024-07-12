package com.nagarro.LibraryManagementApp2.repository;

import com.nagarro.LibraryManagementApp2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String>{
}
