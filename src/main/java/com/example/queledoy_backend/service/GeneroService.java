package com.example.queledoy_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.queledoy_backend.model.Genero;
import com.example.queledoy_backend.repository.GeneroRepository;
import java.util.List;

@Service
public class GeneroService {
    
    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> getAllGeneros() {
        return generoRepository.findAll();
    }

    public Genero getGeneroById(Integer id) {
        return generoRepository.findById(id).orElse(null);
    }

    public Genero saveGenero(Genero genero) {
        return generoRepository.save(genero);
    }

    public void deleteGenero(Integer id) {
        generoRepository.deleteById(id);
    }
}