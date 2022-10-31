package com.example.crud.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.Shoes;

public interface ShoeRepository extends JpaRepository<Shoes, Long> {
}


