package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "permisos_usuarios")
public class PermisoUsuario {
    @Id
    @Column(name = "id_permiso_usuario")
    private int idPermisoUsuario;

    @ManyToOne
    @JoinColumn(name = "id_permiso")
    private Permiso permiso;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public PermisoUsuario(Permiso permiso, Usuario usuario) {
        this.permiso = permiso;
        this.usuario = usuario;
    }

    public PermisoUsuario() {

    }

    public int getIdPermisoUsuario() {
        return idPermisoUsuario;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setIdPermisoUsuario(int idPermisoUsuario) {
        this.idPermisoUsuario = idPermisoUsuario;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}