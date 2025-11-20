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

import com.example.queledoy_backend.model.Imagenes;
import com.example.queledoy_backend.service.ImagenesService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/imagenes")
public class ImagenesController {

    @Autowired
    private ImagenesService imagenesService;
    
    @GetMapping
    public List<Imagenes> getAllImagenes() {
        return imagenesService.getAllImagenes();
    }

    @GetMapping("/{id}")
    public Imagenes getImagenesById(@PathVariable Integer id) {
        return imagenesService.getImagenesById(id);
    }

    @PostMapping
    public Imagenes saveImagenes(@RequestBody Imagenes imagenes) {
        return imagenesService.saveImagenes(imagenes);
    }

    @PutMapping("/{id}")
    public Imagenes updateImagenes(@PathVariable Integer id, @RequestBody Imagenes imagenes) {
        imagenes.setId(id);
        return imagenesService.saveImagenes(imagenes);
    }

    @DeleteMapping("/{id}")
    public void deleteImagenes(@PathVariable Integer id) {
        imagenesService.deleteImagenes(id);
    }
}