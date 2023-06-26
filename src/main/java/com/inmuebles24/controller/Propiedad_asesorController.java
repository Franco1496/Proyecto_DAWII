package com.inmuebles24.controller;

import com.inmuebles24.dtos.Propiedad_asesorDTO;
import com.inmuebles24.service.Propiedad_asesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/propiedadAsesor")
public class Propiedad_asesorController {
    @Autowired
    private Propiedad_asesorService propiedad_asesorService;

    @RequestMapping(value = "/{id_propiedad_asesor}" , method = RequestMethod.GET)
    public ResponseEntity<Propiedad_asesorDTO> obtener(@PathVariable(name = "id_propiedad_asesor") long id_propiedad_asesor){
        return new ResponseEntity<>(propiedad_asesorService.find(id_propiedad_asesor) , HttpStatus.OK);
    }

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public ResponseEntity <List<Propiedad_asesorDTO>> lista(){
        return new ResponseEntity<>(propiedad_asesorService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/" , method = RequestMethod.POST)
    public ResponseEntity <Propiedad_asesorDTO> guardar(@RequestBody Propiedad_asesorDTO propiedad_asesorDTO){
        return new ResponseEntity<>(propiedad_asesorService.save(propiedad_asesorDTO) , HttpStatus.CREATED);
    }

    @RequestMapping(value = "/" , method = RequestMethod.PUT)
    public ResponseEntity<Propiedad_asesorDTO> actualizar(@RequestBody Propiedad_asesorDTO propiedad_asesorDTO){
        return new ResponseEntity<>(propiedad_asesorService.save(propiedad_asesorDTO) , HttpStatus.CREATED);

    }

    @RequestMapping(value = "/{id_propiedad_asesor}" , method = RequestMethod.DELETE)
    public void eliminar(@PathVariable(name = "id_propiedad_asesor") long id_propiedad_asesor) {
        propiedad_asesorService.delete(id_propiedad_asesor);}



}
