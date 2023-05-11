package com.inmuebles24.mappers;

import com.inmuebles24.dtos.ClienteDTO;
import com.inmuebles24.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO clienteAClienteDTO(Cliente cliente);

    Cliente clienteDTOACliente(ClienteDTO clienteDTO);

    List<ClienteDTO> listaClienteAClienteDTO(List<Cliente> cliente);

    List<Cliente> listaClienteDTOACliente(List<ClienteDTO> clienteDTOLista);
}
