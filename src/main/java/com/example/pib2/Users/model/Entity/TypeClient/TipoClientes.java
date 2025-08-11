package com.example.pib2.Users.model.Entity.TypeClient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipoclientes", schema = "dbo")
public class TipoClientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoCliente")
    private Long idTipoCliente;

    @Column(name = "Descripcion", length = 255)
    private String descripcion;

    // Constructor vacío (obligatorio para JPA)
    public TipoClientes() {
    }

    // Constructor con campos
    public TipoClientes(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Long getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(Long idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
