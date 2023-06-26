package com.inmuebles24.controller;

import com.inmuebles24.dtos.ClienteDTO;
import com.inmuebles24.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/cliente")
@PreAuthorize("hasRole('ADMIN')")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/{id_cliente}", method = RequestMethod.GET)
    public ResponseEntity<ClienteDTO> obtener(@PathVariable(name = "id_cliente") long id_cliente) {
        return new ResponseEntity<>(clienteService.find(id_cliente), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<ClienteDTO>> lista() {
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ClienteDTO> guardar(@RequestBody ClienteDTO clienteDTO) {
        return new ResponseEntity<>(clienteService.save(clienteDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<ClienteDTO> actualizar(@RequestBody ClienteDTO clienteDTO) {
        return new ResponseEntity<>(clienteService.save(clienteDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id_cliente}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable(name = "id_cliente") long id_cliente) {
        clienteService.delete(id_cliente);
    }
}
