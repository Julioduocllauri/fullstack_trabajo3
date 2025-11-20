package com.example.queledoy_backend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.queledoy_backend.model.Categorias;
import com.example.queledoy_backend.repository.CategoriasRepository;

@ExtendWith(MockitoExtension.class)
class CategoriasServiceTest {

    @Mock
    private CategoriasRepository categoriasRepository;

    @InjectMocks
    private CategoriasService categoriasService;

    private Categorias categorias;

    @BeforeEach
    void setUp() {
        categorias = new Categorias();
        categorias.setId(1);
        categorias.setNombre("Categoría Test");
    }

    @Test
    void testGetAllCategorias() {
        List<Categorias> categoriasList = Arrays.asList(categorias);
        when(categoriasRepository.findAll()).thenReturn(categoriasList);

        List<Categorias> result = categoriasService.getAllCategorias();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Categoría Test", result.get(0).getNombre());
        verify(categoriasRepository).findAll();
    }

    @Test
    void testGetCategoriasById() {
        when(categoriasRepository.findById(1)).thenReturn(Optional.of(categorias));

        Categorias result = categoriasService.getCategoriasById(1);

        assertNotNull(result);
        assertEquals("Categoría Test", result.getNombre());
        verify(categoriasRepository).findById(1);
    }

    @Test
    void testSaveCategorias() {
        when(categoriasRepository.save(categorias)).thenReturn(categorias);

        Categorias result = categoriasService.saveCategorias(categorias);

        assertNotNull(result);
        assertEquals("Categoría Test", result.getNombre());
        verify(categoriasRepository).save(categorias);
    }

    @Test
    void testDeleteCategorias() {
        categoriasService.deleteCategorias(1);

        verify(categoriasRepository).deleteById(1);
    }
}