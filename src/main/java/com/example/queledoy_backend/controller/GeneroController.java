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

import com.example.queledoy_backend.model.Genero;
import com.example.queledoy_backend.service.GeneroService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/genero")
public class GeneroController {

    @Autowired
    private GeneroService generoService;
    
    @GetMapping
    public List<Genero> getAllGeneros() {
        return generoService.getAllGeneros();
    }

    @GetMapping("/{id}")
    public Genero getGeneroById(@PathVariable Integer id) {
        return generoService.getGeneroById(id);
    }

    @PostMapping
    public Genero saveGenero(@RequestBody Genero genero) {
        return generoService.saveGenero(genero);
    }

    @PutMapping("/{id}")
    public Genero updateGenero(@PathVariable Integer id, @RequestBody Genero genero) {
        genero.setId(id);
        return generoService.saveGenero(genero);
    }

    @DeleteMapping("/{id}")
    public void deleteGenero(@PathVariable Integer id) {
        generoService.deleteGenero(id);
    }
}