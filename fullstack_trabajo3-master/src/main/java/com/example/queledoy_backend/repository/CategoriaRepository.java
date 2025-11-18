package com.example.queledoy_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.queledoy_backend.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}