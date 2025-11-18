package com.example.queledoy_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.queledoy_backend.model.Categorias;
import com.example.queledoy_backend.service.CategoriasService;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

    @Autowired
    private CategoriasService categoriasService;
    
    @GetMapping
    public List<Categorias> getAllCategorias() {
        return categoriasService.getAllCategorias();
    }

    @GetMapping("/{id}")
    public Categorias getCategoriasById(@PathVariable Integer id) {
        return categoriasService.getCategoriasById(id);
    }

    @PostMapping
    public Categorias saveCategorias(@RequestBody Categorias categorias) {
        return categoriasService.saveCategorias(categorias);
    }

    @DeleteMapping("/{id}")
    public void deleteCategorias(@PathVariable Integer id) {
        categoriasService.deleteCategorias(id);
    }
}