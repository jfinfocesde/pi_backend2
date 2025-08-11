package com.example.pib2.Users.model.dto.TypeClientsDTO;

public class TypeClientsDTO {
    private Long IdTipoCliente;
    private String Descripcion;

    public TypeClientsDTO() {}

    public TypeClientsDTO(String Descripcion, Long IdTipoCliente) {
        this.Descripcion = Descripcion;
        this.IdTipoCliente = IdTipoCliente;
    }

    public Long getIdTipoCliente() {
        return IdTipoCliente;
    }

    public void setIdTipoCliente(Long IdTipoCliente) {
        this.IdTipoCliente = IdTipoCliente;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}
