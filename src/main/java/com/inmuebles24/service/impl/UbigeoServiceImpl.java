package com.inmuebles24.service.impl;

import com.inmuebles24.dtos.UbigeoDTO;
import com.inmuebles24.mappers.UbigeoMapper;
import com.inmuebles24.model.Ubigeo;
import com.inmuebles24.repository.UbigeoRepository;
import com.inmuebles24.service.UbigeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UbigeoServiceImpl implements UbigeoService {
    @Autowired
    private UbigeoRepository ubigeoRepository;
    private UbigeoMapper ubigeoMapper = UbigeoMapper.INSTANCE;

    @Override
    public UbigeoDTO find(Long id_ubigeo) {
        Optional<Ubigeo> ubigeo = ubigeoRepository.findById(id_ubigeo);
        if (ubigeo.isPresent()) {
            return ubigeoMapper.ubigeoAUbigeoDTO(ubigeo.get());
        }
        throw new RuntimeException();
    }

    @Override
    public List<UbigeoDTO> findAll() {
        return ubigeoMapper.listaUbigeoAUbigeoDTO((ubigeoRepository.findAll()));
    }

    @Override
    public UbigeoDTO save(UbigeoDTO ubigeoDTO) {
        return ubigeoMapper.ubigeoAUbigeoDTO(ubigeoRepository.save(ubigeoMapper.ubigeoDTOAUbigeo(ubigeoDTO)));
    }

    @Override
    public void delete(Long id_ubigeo) {
        ubigeoRepository.deleteById(id_ubigeo);
    }
}
