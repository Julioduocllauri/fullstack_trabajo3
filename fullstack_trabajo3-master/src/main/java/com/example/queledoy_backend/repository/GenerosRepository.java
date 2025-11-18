package com.example.queledoy_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.queledoy_backend.model.Generos;

public interface GenerosRepository extends JpaRepository<Generos, Integer> {
}