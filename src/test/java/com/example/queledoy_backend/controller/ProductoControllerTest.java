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

import com.example.queledoy_backend.model.Producto;
import com.example.queledoy_backend.service.ProductoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ProductoController.class)
class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService productoService;

    @Autowired
    private ObjectMapper objectMapper;

    private Producto producto;

    @BeforeEach
    void setUp() {
        producto = new Producto();
        producto.setId(1);
        producto.setNombre("Producto Test");
        producto.setPrecio(100.0);
        producto.setDescripcion("Descripción test");
        producto.setStock(10);
        producto.setActivo(true);
        producto.setDestacado(false);
        producto.setUrl("http://test.com");
    }

    @Test
    void testGetAllProductos() throws Exception {
        List<Producto> productos = Arrays.asList(producto);
        when(productoService.getAllProductos()).thenReturn(productos);

        mockMvc.perform(get("/api/v1/productos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nombre").value("Producto Test"))
                .andExpect(jsonPath("$[0].precio").value(100.0));

        verify(productoService).getAllProductos();
    }

    @Test
    void testGetProductoById() throws Exception {
        when(productoService.getProductoById(1)).thenReturn(producto);


        mockMvc.perform(get("/api/v1/productos/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Producto Test"))
                .andExpect(jsonPath("$.precio").value(100.0));

        verify(productoService).getProductoById(1);
    }

    @Test
    void testSaveProducto() throws Exception {
        when(productoService.saveProducto(any(Producto.class))).thenReturn(producto);
        mockMvc.perform(post("/api/v1/productos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(producto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Producto Test"));

        verify(productoService).saveProducto(any(Producto.class));
    }

    @Test
    void testDeleteProducto() throws Exception {
        mockMvc.perform(delete("/api/v1/productos/1"))
                .andExpect(status().isOk());

        verify(productoService).deleteProducto(1);
    }
}