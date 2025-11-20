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

import com.example.queledoy_backend.model.Lista;
import com.example.queledoy_backend.service.ListaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/listas")
public class ListaController {

    @Autowired
    private ListaService listaService;
    
    @GetMapping
    public List<Lista> getAllListas() {
        return listaService.getAllListas();
    }

    @GetMapping("/{id}")
    public Lista getListaById(@PathVariable Integer id) {
        return listaService.getListaById(id);
    }

    @PostMapping
    public Lista saveLista(@RequestBody Lista lista) {
        return listaService.saveLista(lista);
    }

    @PutMapping("/{id}")
    public Lista updateLista(@PathVariable Integer id, @RequestBody Lista lista) {
        lista.setId(id);
        return listaService.saveLista(lista);
    }

    @DeleteMapping("/{id}")
    public void deleteLista(@PathVariable Integer id) {
        listaService.deleteLista(id);
    }
}