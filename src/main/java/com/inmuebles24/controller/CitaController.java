package com.inmuebles24.controller;

import com.inmuebles24.dtos.CitaDTO;
import com.inmuebles24.dtos.ClienteDTO;
import com.inmuebles24.service.CitaService;
import com.inmuebles24.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/cita")
@PreAuthorize("hasRole('ADMIN')")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @RequestMapping(value = "/{id_cita}", method = RequestMethod.GET)
    public ResponseEntity<CitaDTO> obtener(@PathVariable(name = "id_cita") long id_cita) {
        return new ResponseEntity<>(citaService.find(id_cita), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<CitaDTO>> lista() {
        return new ResponseEntity<>(citaService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<CitaDTO> guardar(@RequestBody CitaDTO citaDTO) {
        return new ResponseEntity<>(citaService.save(citaDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<CitaDTO> actualizar(@RequestBody CitaDTO citaDTO) {
        return new ResponseEntity<>(citaService.save(citaDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id_cita}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable(name = "id_cita") long id_cita) {
        citaService.delete(id_cita);
    }
}