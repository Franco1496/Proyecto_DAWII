package com.inmuebles24.controller;

import com.inmuebles24.dtos.ClienteDTO;
import com.inmuebles24.dtos.VentaDTO;
import com.inmuebles24.service.ClienteService;
import com.inmuebles24.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/venta")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @RequestMapping(value = "/{id_venta}", method = RequestMethod.GET)
    public ResponseEntity<VentaDTO> obtener(@PathVariable(name = "id_venta") long id_venta) {
        return new ResponseEntity<>(ventaService.find(id_venta), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<VentaDTO>> lista() {
        return new ResponseEntity<>(ventaService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<VentaDTO> guardar(@RequestBody VentaDTO ventaDTO) {
        return new ResponseEntity<>(ventaService.save(ventaDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<VentaDTO> actualizar(@RequestBody VentaDTO ventaDTO) {
        return new ResponseEntity<>(ventaService.save(ventaDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id_venta}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable(name = "id_venta") long id_venta) {
        ventaService.delete(id_venta);
    }
}
