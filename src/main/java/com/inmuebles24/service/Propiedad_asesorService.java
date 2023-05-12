package com.inmuebles24.service;

import com.inmuebles24.dtos.Propiedad_asesorDTO;

import java.util.List;

public interface Propiedad_asesorService {

    Propiedad_asesorDTO find(Long id_propiedad_asesor);

    List<Propiedad_asesorDTO> findAll();

    Propiedad_asesorDTO save(Propiedad_asesorDTO propiedad_asesorDTO);

    void delete(Long id_cliente);

}
