package com.inmuebles24.service;

import com.inmuebles24.dtos.UbigeoDTO;

import java.util.List;

public interface UbigeoService {
    UbigeoDTO find(Long id_ubigeo);
    List<UbigeoDTO> findAll();
    UbigeoDTO save(UbigeoDTO ubigeoDTO);
    void delete(Long id_ubigeo);
}
