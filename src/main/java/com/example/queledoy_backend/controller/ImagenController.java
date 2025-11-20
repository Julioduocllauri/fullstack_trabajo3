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

import com.example.queledoy_backend.model.Imagen;
import com.example.queledoy_backend.service.ImagenService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/imagen")
public class ImagenController {

    @Autowired
    private ImagenService imagenService;
    
    @GetMapping
    public List<Imagen> getAllImagenes() {
        return imagenService.getAllImagenes();
    }

    @GetMapping("/{id}")
    public Imagen getImagenById(@PathVariable Integer id) {
        return imagenService.getImagenById(id);
    }

    @PostMapping
    public Imagen saveImagen(@RequestBody Imagen imagen) {
        return imagenService.saveImagen(imagen);
    }

    @PutMapping("/{id}")
    public Imagen updateImagen(@PathVariable Integer id, @RequestBody Imagen imagen) {
        imagen.setId(id);
        return imagenService.saveImagen(imagen);
    }

    @DeleteMapping("/{id}")
    public void deleteImagen(@PathVariable Integer id) {
        imagenService.deleteImagen(id);
    }
}