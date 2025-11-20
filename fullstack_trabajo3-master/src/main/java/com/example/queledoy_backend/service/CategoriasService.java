package com.example.queledoy_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.queledoy_backend.model.Categorias;
import com.example.queledoy_backend.repository.CategoriasRepository;
import java.util.List;

@Service
public class CategoriasService {
    
    @Autowired
    private CategoriasRepository categoriasRepository;

    public List<Categorias> getAllCategorias() {
        return categoriasRepository.findAll();
    }

    public Categorias getCategoriasById(Integer id) {
        return categoriasRepository.findById(id).orElse(null);
    }

    public Categorias saveCategorias(Categorias categorias) {
        return categoriasRepository.save(categorias);
    }

    public void deleteCategorias(Integer id) {
        categoriasRepository.deleteById(id);
    }
}