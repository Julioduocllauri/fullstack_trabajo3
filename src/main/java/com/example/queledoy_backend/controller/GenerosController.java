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

import com.example.queledoy_backend.model.Generos;
import com.example.queledoy_backend.service.GenerosService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/generos")
public class GenerosController {

    @Autowired
    private GenerosService generosService;
    
    @GetMapping
    public List<Generos> getAllGeneros() {
        return generosService.getAllGeneros();
    }

    @GetMapping("/{id}")
    public Generos getGenerosById(@PathVariable Integer id) {
        return generosService.getGenerosById(id);
    }

    @PostMapping
    public Generos saveGeneros(@RequestBody Generos generos) {
        return generosService.saveGeneros(generos);
    }

    @PutMapping("/{id}")
    public Generos updateGeneros(@PathVariable Integer id, @RequestBody Generos generos) {
        generos.setId(id);
        return generosService.saveGeneros(generos);
    }

    @DeleteMapping("/{id}")
    public void deleteGeneros(@PathVariable Integer id) {
        generosService.deleteGeneros(id);
    }
}