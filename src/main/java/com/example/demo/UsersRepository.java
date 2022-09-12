package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface UsersRepository extends JpaRepository<Users, Long> {


    Users findByEmail(String email);

}
