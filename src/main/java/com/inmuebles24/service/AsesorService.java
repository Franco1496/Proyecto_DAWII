package com.inmuebles24.service;

import com.inmuebles24.dtos.AsesorDTO;

import java.util.List;

public interface AsesorService {

    AsesorDTO find(Long id_asesor);
    List<AsesorDTO> findAll();

    AsesorDTO save(AsesorDTO asesorDTO);

    void delete (Long id_asesor);

}
