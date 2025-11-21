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
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
@Tag(name = "Productos", description = "API para gestión de productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    
    @GetMapping
    @Operation(summary = "Obtener todos los productos", description = "Devuelve una lista de todos los productos disponibles")
    @ApiResponse(responseCode = "200", description = "Lista de productos obtenida exitosamente")
    public ResponseEntity<List<ProductoDTO>> getAllProductos() {
        List<Producto> productos = productoService.getAllProductos();
        List<ProductoDTO> productosDTO = productos.stream().map(ProductoDTO::fromProducto).collect(Collectors.toList());
        return ResponseEntity.ok(productosDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto por ID", description = "Devuelve un producto específico por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto encontrado"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public ResponseEntity<ProductoDTO> getProductoById(@PathVariable Integer id) {
        Producto producto = productoService.getProductoById(id);
        if (producto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(ProductoDTO.fromProducto(producto));
    }
    // DTO para exponer los campos planos necesarios al frontend
    public static class ProductoDTO {
        public Integer id;
        public String nombre_producto;
        public Double precio;
        public String descripcion_producto;
        public String url_imagen;
        public String categoria;
        public String link_mercado;

        public static ProductoDTO fromProducto(Producto producto) {
            ProductoDTO dto = new ProductoDTO();
            dto.id = producto.getId();
            dto.nombre_producto = producto.getNombre();
            dto.precio = producto.getPrecio();
            dto.descripcion_producto = producto.getDescripcion();
            // url_imagen: navega hasta producto.getImagenes().getImagen().getUrl() si existen
            if (producto.getImagenes() != null && producto.getImagenes().getImagen() != null) {
                dto.url_imagen = producto.getImagenes().getImagen().getUrl();
            } else {
                dto.url_imagen = null;
            }
            // categoria: navega hasta producto.getCategorias().getNombre() si existe
            if (producto.getCategorias() != null) {
                dto.categoria = producto.getCategorias().getNombre();
            } else {
                dto.categoria = null;
            }
            // link_mercado: usa el campo url
            dto.link_mercado = producto.getUrl();
            return dto;
        }
    }

    @PostMapping
    @Operation(summary = "Crear nuevo producto", description = "Crea un nuevo producto en el sistema")
    @ApiResponse(responseCode = "201", description = "Producto creado exitosamente")
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