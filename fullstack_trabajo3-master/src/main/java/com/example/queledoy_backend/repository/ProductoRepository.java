package com.example.queledoy_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.queledoy_backend.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}