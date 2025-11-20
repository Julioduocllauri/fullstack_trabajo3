package com.example.queledoy_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.queledoy_backend.model.Imagen;
import com.example.queledoy_backend.repository.ImagenRepository;
import java.util.List;

@Service
public class ImagenService {
    
    @Autowired
    private ImagenRepository imagenRepository;

    public List<Imagen> getAllImagenes() {
        return imagenRepository.findAll();
    }

    public Imagen getImagenById(Integer id) {
        return imagenRepository.findById(id).orElse(null);
    }

    public Imagen saveImagen(Imagen imagen) {
        return imagenRepository.save(imagen);
    }

    public void deleteImagen(Integer id) {
        imagenRepository.deleteById(id);
    }
}