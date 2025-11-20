package com.example.queledoy_backend.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.queledoy_backend.model.Categorias;
import com.example.queledoy_backend.service.CategoriasService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CategoriasController.class)
class CategoriasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoriasService categoriasService;

    @Autowired
    private ObjectMapper objectMapper;

    private Categorias categorias;

    @BeforeEach
    void setUp() {
        categorias = new Categorias();
        categorias.setId(1);
        categorias.setNombre("Categoría Test");
    }

    @Test
    void testGetAllCategorias() throws Exception {
        List<Categorias> categoriasList = Arrays.asList(categorias);
        when(categoriasService.getAllCategorias()).thenReturn(categoriasList);

        mockMvc.perform(get("/api/v1/categorias"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nombre").value("Categoría Test"));

        verify(categoriasService).getAllCategorias();
    }

    @Test
    void testGetCategoriasById() throws Exception {
        when(categoriasService.getCategoriasById(1)).thenReturn(categorias);

        mockMvc.perform(get("/api/v1/categorias/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Categoría Test"));

        verify(categoriasService).getCategoriasById(1);
    }

    @Test
    void testSaveCategorias() throws Exception {
        when(categoriasService.saveCategorias(any(Categorias.class))).thenReturn(categorias);
        mockMvc.perform(post("/api/v1/categorias")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(categorias)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Categoría Test"));

        verify(categoriasService).saveCategorias(any(Categorias.class));
    }

    @Test
    void testDeleteCategorias() throws Exception {
        mockMvc.perform(delete("/api/v1/categorias/1"))
                .andExpect(status().isOk());

        verify(categoriasService).deleteCategorias(1);
    }
}