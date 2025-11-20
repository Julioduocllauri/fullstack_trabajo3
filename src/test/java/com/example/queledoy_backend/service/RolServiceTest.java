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

import com.example.queledoy_backend.model.Rol;
import com.example.queledoy_backend.repository.RolRepository;

@ExtendWith(MockitoExtension.class)
class RolServiceTest {

    @Mock
    private RolRepository rolRepository;

    @InjectMocks
    private RolService rolService;

    private Rol rol;

    @BeforeEach
    void setUp() {
        rol = new Rol();
        rol.setId(1);
        rol.setNombre("ADMIN");
    }

    @Test
    void testGetAllRoles() {

        List<Rol> roles = Arrays.asList(rol);
        when(rolRepository.findAll()).thenReturn(roles);

        List<Rol> result = rolService.getAllRoles();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("ADMIN", result.get(0).getNombre());
        verify(rolRepository).findAll();
    }

    @Test
    void testGetRolById() {

        when(rolRepository.findById(1)).thenReturn(Optional.of(rol));


        Rol result = rolService.getRolById(1);

        assertNotNull(result);
        assertEquals("ADMIN", result.getNombre());
        verify(rolRepository).findById(1);
    }

    @Test
    void testSaveRol() {
        when(rolRepository.save(rol)).thenReturn(rol);

        Rol result = rolService.saveRol(rol);

        assertNotNull(result);
        assertEquals("ADMIN", result.getNombre());
        verify(rolRepository).save(rol);
    }

    @Test
    void testDeleteRol() {

        rolService.deleteRol(1);


        verify(rolRepository).deleteById(1);
    }
}