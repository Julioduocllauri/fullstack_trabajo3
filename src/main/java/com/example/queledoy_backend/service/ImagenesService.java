package com.example.queledoy_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.queledoy_backend.model.Imagenes;
import com.example.queledoy_backend.repository.ImagenesRepository;
import java.util.List;

@Service
public class ImagenesService {
    
    @Autowired
    private ImagenesRepository imagenesRepository;

    public List<Imagenes> getAllImagenes() {
        return imagenesRepository.findAll();
    }

    public Imagenes getImagenesById(Integer id) {
        return imagenesRepository.findById(id).orElse(null);
    }

    public Imagenes saveImagenes(Imagenes imagenes) {
        return imagenesRepository.save(imagenes);
    }

    public void deleteImagenes(Integer id) {
        imagenesRepository.deleteById(id);
    }
}