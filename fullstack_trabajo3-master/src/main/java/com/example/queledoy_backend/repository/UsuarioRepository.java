package com.example.queledoy_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.queledoy_backend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}