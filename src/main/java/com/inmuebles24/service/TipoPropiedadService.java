package com.inmuebles24.service;

import com.inmuebles24.dtos.TipoPropiedadDTO;

import java.util.List;

public interface TipoPropiedadService {

    TipoPropiedadDTO find(Long id_tipo_propiedad);
    List<TipoPropiedadDTO> findAll();
    TipoPropiedadDTO save(TipoPropiedadDTO tipoPropiedadDTO);
    void delete(Long id_tipo_propiedad);

}
