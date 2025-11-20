package com.example.queledoy_backend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.queledoy_backend.model.Usuario;
import com.example.queledoy_backend.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();
        usuario.setId(1);
        usuario.setNombre("Juan Pérez");
        usuario.setCorreo("juan@test.com");
        usuario.setContrasena("password123");
        usuario.setActivo(true);
        usuario.setFechaRegistro(new Date(System.currentTimeMillis()));
    }

    @Test
    void testGetAllUsuarios() {

        List<Usuario> usuarios = Arrays.asList(usuario);
        when(usuarioRepository.findAll()).thenReturn(usuarios);


        List<Usuario> result = usuarioService.getAllUsuarios();


        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Juan Pérez", result.get(0).getNombre());
        verify(usuarioRepository).findAll();
    }

    @Test
    void testGetUsuarioById() {
        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));

        Usuario result = usuarioService.getUsuarioById(1);

        assertNotNull(result);
        assertEquals("Juan Pérez", result.getNombre());
        assertEquals("juan@test.com", result.getCorreo());
        verify(usuarioRepository).findById(1);
    }

    @Test
    void testSaveUsuario() {
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario result = usuarioService.saveUsuario(usuario);

        assertNotNull(result);
        assertEquals("Juan Pérez", result.getNombre());
        verify(usuarioRepository).save(usuario);
    }

    @Test
    void testDeleteUsuario() {
        usuarioService.deleteUsuario(1);

        verify(usuarioRepository).deleteById(1);
    }
}