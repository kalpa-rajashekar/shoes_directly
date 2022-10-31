package com.example.crud.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.User;



public interface UserRepository extends JpaRepository<User, Long> {
}