package com.example.demo;

public class UsersNotFoundException extends RuntimeException {

    UsersNotFoundException(Long id) {
        super("Could not find user " + id);
    }

    UsersNotFoundException(String email) {
        super("Could not find user " + email);
    }
}
