package com.example.queledoy_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.queledoy_backend.model.Imagenes;

public interface ImagenesRepository extends JpaRepository<Imagenes, Integer> {
}