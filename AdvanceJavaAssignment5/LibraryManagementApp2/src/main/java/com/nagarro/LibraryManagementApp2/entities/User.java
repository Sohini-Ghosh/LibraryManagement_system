package com.nagarro.LibraryManagementApp2.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class User {
    @Id
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
