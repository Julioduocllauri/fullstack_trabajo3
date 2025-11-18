package com.example.queledoy_backend.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombreUsuario", length = 50, nullable = false)
    private String nombre;

    @Column(name = "correoUsuario", length = 50, nullable = false)
    private String correo;

    @Column(name = "contrasenaUsuario", length = 100, nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String contrasena;

    @Column(name = "usuarioActivo", length = 100, nullable = false)
    private Boolean activo;

    @Column(name = "fechaRegistro", length = 100, nullable = false)
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "codigo_rol")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "codigo_lista")
    private Lista lista;
}