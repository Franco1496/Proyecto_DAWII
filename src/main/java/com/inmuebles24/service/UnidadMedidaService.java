package com.inmuebles24.service;

import com.inmuebles24.dtos.UnidadMedidaDTO;

import java.util.List;

public interface UnidadMedidaService {

    UnidadMedidaDTO find(Long id_unidad_medida);
    List<UnidadMedidaDTO> findAll();
    UnidadMedidaDTO save(UnidadMedidaDTO unidadMedidaDTO);
    void delete(Long id_unidad_medida);

}
