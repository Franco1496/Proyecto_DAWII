package com.inmuebles24.service;

import com.inmuebles24.dtos.ClienteDTO;

import java.util.List;

public interface ClienteService {
    ClienteDTO find(Long id_cliente);
    List<ClienteDTO> findAll();
    ClienteDTO save(ClienteDTO clienteDTO);
    void delete(Long id_cliente);
}
