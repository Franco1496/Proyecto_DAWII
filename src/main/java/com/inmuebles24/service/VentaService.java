package com.inmuebles24.service;

import com.inmuebles24.dtos.VentaDTO;

import java.util.List;

public interface VentaService {

    VentaDTO find(Long id_venta);

    List<VentaDTO> findAll();

    VentaDTO save(VentaDTO ventaDTO);

    void delete(Long id_venta);
}
