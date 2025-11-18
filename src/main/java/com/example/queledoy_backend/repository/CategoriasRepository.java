package com.example.queledoy_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.queledoy_backend.model.Categorias;

public interface CategoriasRepository extends JpaRepository<Categorias, Integer> {
}