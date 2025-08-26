package com.example.pib2.Users.Service_imple.ServiceImpleUser;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pib2.Users.model.dto.Users.ClientsDTO;
import com.example.pib2.Users.repository.UsersRepository.UserRepository;
import com.example.pib2.Users.service.ServiceUser.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<ClientsDTO> getAllClients() {
        return userRepository.findAll()
                .stream()
                .map(cliente -> ClientsDTO.builder()
                .idCliente(cliente.getIdCliente())
                .nombreCompleto(cliente.getNombreCompleto())
                .telefono(cliente.getTelefono())
                .numeroDocumento(cliente.getNumeroDocumento())
                .activo(cliente.getActivo())
                .fechaNacimiento(cliente.getFechaNacimiento())
                .idTipoCliente(
                    cliente.getTipoCliente() != null ?
                    cliente.getTipoCliente().getIdTipoCliente(): null)
                .tipoClienteDescripcion(
                    cliente.getTipoCliente()!=null ?
                    cliente.getTipoCliente().getTipoCliente(): null  )       
                .build()).collect(Collectors.toList());
    }

}
