package com.example.demo.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "permisos")
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_permiso")
    private int idPermiso;

    @Column(name = "nombre")
    private String nombre;
    @jakarta.persistence.Id
    private Long id;

    public Permiso(String nombre, Long id) {
        this.nombre = nombre;
        this.id = id;
    }

    public Permiso() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getIdPermiso() {
        return idPermiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
// Constructor, getters y setters
}