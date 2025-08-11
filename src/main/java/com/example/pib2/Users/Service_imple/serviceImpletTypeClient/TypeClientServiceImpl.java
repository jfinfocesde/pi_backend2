package com.example.pib2.Users.Service_imple.serviceImpletTypeClient;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.pib2.Users.model.dto.TypeClientsDTO.TypeClientsDTO;
import com.example.pib2.Users.repository.TypeClienteRepository.TypeClienteRepository;
import com.example.pib2.Users.service.serviceTypeClient.TypeClienteService;


@Service
public class TypeClientServiceImpl implements TypeClienteService {

    private final TypeClienteRepository typeClientsRepository;

    public TypeClientServiceImpl(TypeClienteRepository typeClientsRepository) {
        this.typeClientsRepository = typeClientsRepository;
    }

    @Override
    public List<TypeClientsDTO> getAllTypeClients() {
        return typeClientsRepository.findAll()
                .stream()
                .map(entity -> new TypeClientsDTO(entity.getDescripcion(), entity.getIdTipoCliente()
        ))
                .toList();
    }

}
