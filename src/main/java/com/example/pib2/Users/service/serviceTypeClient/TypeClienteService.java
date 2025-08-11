package com.example.pib2.Users.service.serviceTypeClient;

import java.util.List;

import com.example.pib2.Users.model.dto.TypeClientsDTO.TypeClientsDTO;


public interface  TypeClienteService {
     //Para un get all lo correcto es devolverlo en una lista
    List<TypeClientsDTO> getAllTypeClients(); 
}
