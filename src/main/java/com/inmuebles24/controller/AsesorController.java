package com.inmuebles24.controller;

import com.inmuebles24.dtos.AsesorDTO;
import com.inmuebles24.model.Asesor;
import com.inmuebles24.service.AsesorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/asesor")
public class AsesorController {

    @Autowired
    private AsesorService asesorService;

    @RequestMapping(value = "/{id_asesor}" , method = RequestMethod.GET)
    public ResponseEntity<AsesorDTO> obtener(@PathVariable(name = "id_asesor") long id_asesor){
        return new ResponseEntity<>(asesorService.find(id_asesor), HttpStatus.OK);
    }

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public ResponseEntity<List<AsesorDTO>> lista(){
        return new ResponseEntity<>(asesorService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/" , method = RequestMethod.POST)
    public ResponseEntity<AsesorDTO> guardar(@RequestBody AsesorDTO asesorDTO) {
        return new ResponseEntity<>(asesorService.save(asesorDTO), HttpStatus.CREATED);

    }

    @RequestMapping(value = "/" , method = RequestMethod.PUT)
    public ResponseEntity<AsesorDTO> actualizar(@RequestBody AsesorDTO asesorDTO){
        return new ResponseEntity<>(asesorService.save(asesorDTO) , HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id_asesor}" , method = RequestMethod.DELETE)
    public  void eliminar(@PathVariable(name = "id_asesor") long id_asesor) { asesorService.delete(id_asesor);}


}
