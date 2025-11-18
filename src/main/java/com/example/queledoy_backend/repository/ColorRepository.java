package com.example.queledoy_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.queledoy_backend.model.Color;

public interface ColorRepository extends JpaRepository<Color, Integer> {
}