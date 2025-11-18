package com.example.queledoy_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.queledoy_backend.model.Imagen;

public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
}