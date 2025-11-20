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

import com.example.queledoy_backend.model.Categoria;
import com.example.queledoy_backend.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    @GetMapping("/{id}")
    public Categoria getCategoriaById(@PathVariable Integer id) {
        return categoriaService.getCategoriaById(id);
    }

    @PostMapping
    public Categoria saveCategoria(@RequestBody Categoria categoria) {
        return categoriaService.saveCategoria(categoria);
    }

    @PutMapping("/{id}")
    public Categoria updateCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        return categoriaService.saveCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Integer id) {
        categoriaService.deleteCategoria(id);
    }
}