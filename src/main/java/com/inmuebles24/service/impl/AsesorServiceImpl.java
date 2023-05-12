package com.inmuebles24.service.impl;

import com.inmuebles24.dtos.AsesorDTO;
import com.inmuebles24.mappers.AsesorMapper;
import com.inmuebles24.model.Asesor;
import com.inmuebles24.repository.AsesorRepository;
import com.inmuebles24.service.AsesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsesorServiceImpl implements AsesorService {

    @Autowired
    private AsesorRepository asesorRepository;

    private AsesorMapper asesorMapper = AsesorMapper.INSTANCIA;

    @Override
    public AsesorDTO find(Long id_asesor) {
        Optional<Asesor> asesor = asesorRepository.findById(id_asesor);

        if (asesor.isPresent()){
            return asesorMapper.asesorAAsesorDTO(asesor.get());
        }
        throw new RuntimeException();
    }

    @Override
    public List<AsesorDTO> findAll() {
        return asesorMapper.listaClienteAAsesorDTO(asesorRepository.findAll());
    }

    @Override
    public AsesorDTO save(AsesorDTO asesorDTO) {
        return asesorMapper.asesorAAsesorDTO(asesorRepository.save(asesorMapper.asesorDTOAAsesor(asesorDTO)));
    }

    @Override
    public void delete(Long id_asesor) { asesorRepository.deleteById(id_asesor);

    }
}
