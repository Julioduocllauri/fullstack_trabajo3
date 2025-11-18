package com.example.queledoy_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.queledoy_backend.model.Rol;
import com.example.queledoy_backend.repository.RolRepository;
import java.util.List;

@Service
public class RolService {
    
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    public Rol getRolById(Integer id) {
        return rolRepository.findById(id).orElse(null);
    }

    public Rol saveRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public void deleteRol(Integer id) {
        rolRepository.deleteById(id);
    }
}