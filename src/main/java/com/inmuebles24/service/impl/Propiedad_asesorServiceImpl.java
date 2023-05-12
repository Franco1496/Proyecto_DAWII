package com.inmuebles24.service.impl;

import com.inmuebles24.dtos.Propiedad_asesorDTO;
import com.inmuebles24.mappers.Propiedad_asesorMapper;
import com.inmuebles24.model.Propiedad_asesor;
import com.inmuebles24.repository.Propiedad_asesorRepository;
import com.inmuebles24.service.Propiedad_asesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class Propiedad_asesorServiceImpl implements Propiedad_asesorService {

    @Autowired
    private Propiedad_asesorRepository propiedad_asesorRepository;

    private Propiedad_asesorMapper propiedad_asesorMapper = Propiedad_asesorMapper.INSTANCE;


    @Override
    public Propiedad_asesorDTO find(Long id_propiedad_asesor) {
        Optional<Propiedad_asesor> propiedad_asesor = propiedad_asesorRepository.findById(id_propiedad_asesor);
        if (propiedad_asesor.isPresent()){
            return propiedad_asesorMapper.propiedad_asesorAPropiedad_asesorDTO(propiedad_asesor.get());
        }
        throw new RuntimeException();
    }

    @Override
    public List<Propiedad_asesorDTO> findAll() {
        return propiedad_asesorMapper.listaPropiedad_asesorAPropiedad_asesorDTO(propiedad_asesorRepository.findAll());
    }

    @Override
    public Propiedad_asesorDTO save(Propiedad_asesorDTO propiedad_asesorDTO) {
        return propiedad_asesorMapper.propiedad_asesorAPropiedad_asesorDTO(propiedad_asesorRepository.save(propiedad_asesorMapper.propiedad_asesorDTOAPropiedad_asesor(propiedad_asesorDTO)));
    }

    @Override
    public void delete(Long id_propiedad_asesor) { propiedad_asesorRepository.deleteById(id_propiedad_asesor);}

    }

