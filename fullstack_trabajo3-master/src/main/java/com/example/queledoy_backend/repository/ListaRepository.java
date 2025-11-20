package com.example.queledoy_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.queledoy_backend.model.Lista;

public interface ListaRepository extends JpaRepository<Lista, Integer> {
}