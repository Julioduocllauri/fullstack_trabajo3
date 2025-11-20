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

import com.example.queledoy_backend.model.Producto;
import com.example.queledoy_backend.repository.ProductoRepository;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

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
    void testGetAllProductos() {
        List<Producto> productos = Arrays.asList(producto);
        when(productoRepository.findAll()).thenReturn(productos);

        List<Producto> result = productoService.getAllProductos();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Producto Test", result.get(0).getNombre());
        verify(productoRepository).findAll();
    }

    @Test
    void testGetProductoById() {
        when(productoRepository.findById(1)).thenReturn(Optional.of(producto));
        Producto result = productoService.getProductoById(1);

        assertNotNull(result);
        assertEquals("Producto Test", result.getNombre());
        assertEquals(100.0, result.getPrecio());
        verify(productoRepository).findById(1);
    }

    @Test
    void testGetProductoByIdNotFound() {
        when(productoRepository.findById(1)).thenReturn(Optional.empty());

        Producto result = productoService.getProductoById(1);

        assertNull(result);
        verify(productoRepository).findById(1);
    }

    @Test
    void testSaveProducto() {
        when(productoRepository.save(producto)).thenReturn(producto);

        Producto result = productoService.saveProducto(producto);

        assertNotNull(result);
        assertEquals("Producto Test", result.getNombre());
        verify(productoRepository).save(producto);
    }

    @Test
    void testDeleteProducto() {
        productoService.deleteProducto(1);

        verify(productoRepository).deleteById(1);
    }
}