package com.example.queledoy_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.queledoy_backend.model.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {
}