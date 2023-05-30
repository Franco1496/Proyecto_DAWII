package com.inmuebles24.service.impl;

import com.inmuebles24.dtos.CitaDTO;
import com.inmuebles24.mappers.CitaMapper;
import com.inmuebles24.model.Cita;
import com.inmuebles24.repository.CitaRepository;
import com.inmuebles24.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository citaRepository;

    private CitaMapper citaMapper = CitaMapper.INSTANCE;



    @Override
    public CitaDTO find(Long id_cita) {
        Optional<Cita> cita = citaRepository.findById(id_cita);
        if (cita.isPresent()) {
            return citaMapper.citaACitaDTO(cita.get());
        }
        throw new RuntimeException();
    }

    @Override
    public List<CitaDTO> findAll() {
        return citaMapper.listaCitaACitaDTO(citaRepository.findAll());
    }

    @Override
    public CitaDTO save(CitaDTO citaDTO) {
        return citaMapper.citaACitaDTO(citaRepository.save(citaMapper.citaDTOACita(citaDTO)));
    }

    @Override
    public void delete(Long id_cita) { citaRepository.deleteById(id_cita);

    }
}
