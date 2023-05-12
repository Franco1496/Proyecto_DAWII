package com.inmuebles24.service;



import com.inmuebles24.dtos.PropiedadDTO;

import java.util.List;

public interface PropiedadService {

    PropiedadDTO find(Long id_propiedad);
    List<PropiedadDTO> findAll();
    PropiedadDTO save(PropiedadDTO propiedadDTO);
    void delete(Long id_propiedad);
}
