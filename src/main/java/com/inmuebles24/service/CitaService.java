package com.inmuebles24.service;

import com.inmuebles24.dtos.CitaDTO;
import com.inmuebles24.model.Cita;

import java.util.List;

public interface CitaService {

    CitaDTO find(Long id_cita);
    List<CitaDTO> findAll();

    CitaDTO save(CitaDTO citaDTO);

    void delete(Long id_cita);
}
