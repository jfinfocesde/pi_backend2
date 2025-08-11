package com.example.pib2.Users.repository.TypeClienteRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pib2.Users.model.Entity.TypeClient.TipoClientes;


public interface TypeClienteRepository extends JpaRepository<TipoClientes, Long> {

}
