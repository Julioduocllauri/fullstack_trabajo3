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

import com.example.queledoy_backend.model.Rol;
import com.example.queledoy_backend.service.RolService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RolController {

    @Autowired
    private RolService rolService;
    
    @GetMapping
    public List<Rol> getAllRoles() {
        return rolService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Rol getRolById(@PathVariable Integer id) {
        return rolService.getRolById(id);
    }

    @PostMapping
    public Rol saveRol(@RequestBody Rol rol) {
        return rolService.saveRol(rol);
    }

    @PutMapping("/{id}")
    public Rol updateRol(@PathVariable Integer id, @RequestBody Rol rol) {
        rol.setId(id);
        return rolService.saveRol(rol);
    }

    @DeleteMapping("/{id}")
    public void deleteRol(@PathVariable Integer id) {
        rolService.deleteRol(id);
    }
}