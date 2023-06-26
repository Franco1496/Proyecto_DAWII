package com.inmuebles24.controller;

import com.inmuebles24.dtos.UnidadMedidaDTO;
import com.inmuebles24.service.UnidadMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/unidadMedida")
public class UnidadMedidaController {

    @Autowired
    private UnidadMedidaService unidadMedidaService;

    @RequestMapping(value = "/{id_unidad_medida}", method = RequestMethod.GET)
    public ResponseEntity<UnidadMedidaDTO> obtener(@PathVariable(name = "id_unidad_medida") long id_unidad_medida) {
        return new ResponseEntity<>(unidadMedidaService.find(id_unidad_medida), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<UnidadMedidaDTO>> lista() {
        return new ResponseEntity<>(unidadMedidaService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<UnidadMedidaDTO> guardar(@RequestBody UnidadMedidaDTO unidadMedidaDTO) {
        return new ResponseEntity<>(unidadMedidaService.save(unidadMedidaDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<UnidadMedidaDTO> actualizar(@RequestBody UnidadMedidaDTO unidadMedidaDTO) {
        return new ResponseEntity<>(unidadMedidaService.save(unidadMedidaDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id_unidad_medida}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable(name = "id_unidad_medida") long id_unidad_medida) {
        unidadMedidaService.delete(id_unidad_medida);
    }

}
