package com.example.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column(name = "id_ticket")
    private int idTicket;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "id_analista")
    private int idAnalista;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "prioridad")
    private String prioridad;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "respuesta")
    private String respuesta;

    public Ticket(int idAnalista, LocalDate fecha, String prioridad, String descripcion, String estado, String respuesta) {
        this.idAnalista = idAnalista;
        this.fecha = fecha;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.estado = estado;
        this.respuesta = respuesta;
    }

    public Ticket() {
    }

    public int getIdTicket() {
        return idTicket;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int getIdAnalista() {
        return idAnalista;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setIdAnalista(int idAnalista) {
        this.idAnalista = idAnalista;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}