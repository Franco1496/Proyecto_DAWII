package com.inmuebles24.controller;

import com.inmuebles24.dtos.TipoPropiedadDTO;
import com.inmuebles24.service.TipoPropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/tipoPropiedad")
public class TipoPropiedadController {

    @Autowired
    private TipoPropiedadService tipoPropiedadService;

    @RequestMapping(value = "/{id_tipo_propiedad}", method = RequestMethod.GET)
    public ResponseEntity<TipoPropiedadDTO> obtener(@PathVariable(name = "id_tipo_propiedad") long id_tipo_propiedad) {
        return new ResponseEntity<>(tipoPropiedadService.find(id_tipo_propiedad), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<TipoPropiedadDTO>> lista(){
        return new ResponseEntity<>(tipoPropiedadService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<TipoPropiedadDTO> guardar(@RequestBody TipoPropiedadDTO tipoPropiedadDTO) {
        return new ResponseEntity<>(tipoPropiedadService.save(tipoPropiedadDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<TipoPropiedadDTO> actualizar(@RequestBody TipoPropiedadDTO tipoPropiedadDTO) {
        return new ResponseEntity<>(tipoPropiedadService.save(tipoPropiedadDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id_tipo_propiedad}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable(name = "id_tipo_propiedad") long id_tipo_propiedad) {
        tipoPropiedadService.delete(id_tipo_propiedad);
    }

}
