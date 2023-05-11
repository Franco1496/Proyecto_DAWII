package com.inmuebles24.service.impl;

import com.inmuebles24.dtos.ClienteDTO;
import com.inmuebles24.mappers.ClienteMapper;
import com.inmuebles24.model.Cliente;
import com.inmuebles24.repository.ClienteRepository;
import com.inmuebles24.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper = ClienteMapper.INSTANCE;

    @Override
    public ClienteDTO find(Long id_cliente) {
        Optional<Cliente> cliente = clienteRepository.findById(id_cliente);
        if (cliente.isPresent()) {
            return clienteMapper.clienteAClienteDTO(cliente.get());
        }
        throw new RuntimeException();
    }

    @Override
    public List<ClienteDTO> findAll() {
        return clienteMapper.listaClienteAClienteDTO(clienteRepository.findAll());
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        return clienteMapper.clienteAClienteDTO(clienteRepository.save(clienteMapper.clienteDTOACliente(clienteDTO)));
    }

    @Override
    public void delete(Long id_cliente) {
        clienteRepository.deleteById(id_cliente);
    }
}
