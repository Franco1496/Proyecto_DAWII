package com.inmuebles24.controller;

import com.inmuebles24.dtos.PropiedadDTO;
import com.inmuebles24.service.PropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/propiedad")
@PreAuthorize("hasRole('ADMIN')")
public class PropiedadController {

    @Autowired
    PropiedadService services;

    @RequestMapping(value = "/{idPropiedad}",method = RequestMethod.GET)
    public ResponseEntity<PropiedadDTO> getPropiedadById(@PathVariable Long idPropiedad){
        return new ResponseEntity<>(services.find(idPropiedad), HttpStatus.OK);
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity<List<PropiedadDTO>> getAllPropiedades(){
        return new ResponseEntity<>(services.findAll(),HttpStatus.OK);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<PropiedadDTO> savePropiedad(@RequestBody PropiedadDTO propiedadDTO){
           return new ResponseEntity<>(services.save(propiedadDTO),HttpStatus.CREATED);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public ResponseEntity<PropiedadDTO> updatePropiedad(@RequestBody PropiedadDTO propiedadDTO){
        return new ResponseEntity<>(services.save(propiedadDTO),HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{idPropiedad}",method = RequestMethod.DELETE)
    public void  deletePropiedad(@PathVariable Long idPropiedad){
        services.delete(idPropiedad);
    }

}
