package com.example.queledoy_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.queledoy_backend.model.Colores;
import com.example.queledoy_backend.repository.ColoresRepository;
import java.util.List;

@Service
public class ColoresService {
    
    @Autowired
    private ColoresRepository coloresRepository;

    public List<Colores> getAllColores() {
        return coloresRepository.findAll();
    }

    public Colores getColoresById(Integer id) {
        return coloresRepository.findById(id).orElse(null);
    }

    public Colores saveColores(Colores colores) {
        return coloresRepository.save(colores);
    }

    public void deleteColores(Integer id) {
        coloresRepository.deleteById(id);
    }
}