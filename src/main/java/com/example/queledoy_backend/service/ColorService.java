package com.example.queledoy_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.queledoy_backend.model.Color;
import com.example.queledoy_backend.repository.ColorRepository;
import java.util.List;

@Service
public class ColorService {
    
    @Autowired
    private ColorRepository colorRepository;

    public List<Color> getAllColores() {
        return colorRepository.findAll();
    }

    public Color getColorById(Integer id) {
        return colorRepository.findById(id).orElse(null);
    }

    public Color saveColor(Color color) {
        return colorRepository.save(color);
    }

    public void deleteColor(Integer id) {
        colorRepository.deleteById(id);
    }
}