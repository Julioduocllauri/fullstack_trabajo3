package com.example.queledoy_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.queledoy_backend.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}