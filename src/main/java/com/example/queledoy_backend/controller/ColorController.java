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

import com.example.queledoy_backend.model.Color;
import com.example.queledoy_backend.service.ColorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/color")
public class ColorController {

    @Autowired
    private ColorService colorService;
    
    @GetMapping
    public List<Color> getAllColores() {
        return colorService.getAllColores();
    }

    @GetMapping("/{id}")
    public Color getColorById(@PathVariable Integer id) {
        return colorService.getColorById(id);
    }

    @PostMapping
    public Color saveColor(@RequestBody Color color) {
        return colorService.saveColor(color);
    }

    @PutMapping("/{id}")
    public Color updateColor(@PathVariable Integer id, @RequestBody Color color) {
        color.setId(id);
        return colorService.saveColor(color);
    }

    @DeleteMapping("/{id}")
    public void deleteColor(@PathVariable Integer id) {
        colorService.deleteColor(id);
    }
}