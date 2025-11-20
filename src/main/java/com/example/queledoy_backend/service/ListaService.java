package com.example.queledoy_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.queledoy_backend.model.Lista;
import com.example.queledoy_backend.repository.ListaRepository;
import java.util.List;

@Service
public class ListaService {
    
    @Autowired
    private ListaRepository listaRepository;

    public List<Lista> getAllListas() {
        return listaRepository.findAll();
    }

    public Lista getListaById(Integer id) {
        return listaRepository.findById(id).orElse(null);
    }

    public Lista saveLista(Lista lista) {
        return listaRepository.save(lista);
    }

    public void deleteLista(Integer id) {
        listaRepository.deleteById(id);
    }
}