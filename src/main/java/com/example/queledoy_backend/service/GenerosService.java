package com.example.queledoy_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.queledoy_backend.model.Generos;
import com.example.queledoy_backend.repository.GenerosRepository;
import java.util.List;

@Service
public class GenerosService {
    
    @Autowired
    private GenerosRepository generosRepository;

    public List<Generos> getAllGeneros() {
        return generosRepository.findAll();
    }

    public Generos getGenerosById(Integer id) {
        return generosRepository.findById(id).orElse(null);
    }

    public Generos saveGeneros(Generos generos) {
        return generosRepository.save(generos);
    }

    public void deleteGeneros(Integer id) {
        generosRepository.deleteById(id);
    }
}