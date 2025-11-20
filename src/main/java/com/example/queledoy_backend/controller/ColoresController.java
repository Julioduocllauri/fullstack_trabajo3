package com.example.queledoy_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.queledoy_backend.model.Colores;
import com.example.queledoy_backend.service.ColoresService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/colores")
public class ColoresController {

    @Autowired
    private ColoresService coloresService;
    
    @GetMapping
    public List<Colores> getAllColores() {
        return coloresService.getAllColores();
    }

    @GetMapping("/{id}")
    public Colores getColoresById(@PathVariable Integer id) {
        return coloresService.getColoresById(id);
    }

    @PostMapping
    public Colores saveColores(@RequestBody Colores colores) {
        return coloresService.saveColores(colores);
    }

    @PutMapping("/{id}")
    public Colores updateColores(@PathVariable Integer id, @RequestBody Colores colores) {
        colores.setId(id);
        return coloresService.saveColores(colores);
    }

    @DeleteMapping("/{id}")
    public void deleteColores(@PathVariable Integer id) {
        coloresService.deleteColores(id);
    }
}