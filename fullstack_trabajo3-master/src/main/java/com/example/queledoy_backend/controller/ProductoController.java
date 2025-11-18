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

import com.example.queledoy_backend.model.Producto;
import com.example.queledoy_backend.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    
    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Integer id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    public Producto saveProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        Producto existingProducto = productoService.getProductoById(id);
        if (existingProducto != null) {
            existingProducto.setNombre(producto.getNombre());
            existingProducto.setUrl(producto.getUrl());
            existingProducto.setPrecio(producto.getPrecio());
            existingProducto.setDescripcion(producto.getDescripcion());
            existingProducto.setActivo(producto.getActivo());
            existingProducto.setDestacado(producto.getDestacado());
            existingProducto.setStock(producto.getStock());
            existingProducto.setCategorias(producto.getCategorias());
            existingProducto.setLista(producto.getLista());
            existingProducto.setColores(producto.getColores());
            existingProducto.setGeneros(producto.getGeneros());
            existingProducto.setImagenes(producto.getImagenes());
            return productoService.saveProducto(existingProducto);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Integer id) {
        productoService.deleteProducto(id);
    }
}