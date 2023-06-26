package com.inmuebles24.controller;

import com.inmuebles24.dtos.UbigeoDTO;
import com.inmuebles24.service.UbigeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/ubigeo")
@PreAuthorize("hasRole('ADMIN')")
public class UbigeoController {
    @Autowired
    private UbigeoService ubigeoService;

    @RequestMapping(value = "/{id_ubigeo}", method = RequestMethod.GET)
    public ResponseEntity<UbigeoDTO> obtener(@PathVariable(name = "id_ubigeo") long id_ubigeo) {
        return new ResponseEntity<>(ubigeoService.find(id_ubigeo), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<UbigeoDTO>> lista() {
        return new ResponseEntity<>(ubigeoService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<UbigeoDTO> guardar(@RequestBody UbigeoDTO ubigeoDTO) {
        return new ResponseEntity<>(ubigeoService.save(ubigeoDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<UbigeoDTO> actualizar(@RequestBody UbigeoDTO ubigeoDTO) {
        return new ResponseEntity<>(ubigeoService.save(ubigeoDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id_ubigeo}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable(name = "id_ubigeo") long id_ubigeo) {
        ubigeoService.delete(id_ubigeo);
    }
}
