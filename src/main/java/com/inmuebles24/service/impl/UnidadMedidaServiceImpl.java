package com.inmuebles24.service.impl;

import com.inmuebles24.dtos.UnidadMedidaDTO;
import com.inmuebles24.mappers.UnidadMedidaMapper;
import com.inmuebles24.model.UnidadMedida;
import com.inmuebles24.repository.UnidadMedidaRepository;
import com.inmuebles24.service.UnidadMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadMedidaServiceImpl implements UnidadMedidaService {

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    private UnidadMedidaMapper unidadMedidaMapper = UnidadMedidaMapper.INSTANCE;

    @Override
    public UnidadMedidaDTO find(Long id_unidad_medida) {
        Optional<UnidadMedida> unidadMedida = unidadMedidaRepository.findById(id_unidad_medida);
        if (unidadMedida.isPresent()){
            return unidadMedidaMapper.unidadMedidaAUnidadMedidaDTO(unidadMedida.get());
        }
        throw new RuntimeException();
    }

    @Override
    public List<UnidadMedidaDTO> findAll() {
        return unidadMedidaMapper.listaUnidadMedidaAUnidadMedidaDTO(unidadMedidaRepository.findAll());
    }

    @Override
    public UnidadMedidaDTO save(UnidadMedidaDTO unidadMedidaDTO) {
        return unidadMedidaMapper.unidadMedidaAUnidadMedidaDTO(unidadMedidaRepository.save(unidadMedidaMapper.unidadMedidaDTOAUnidadMedida(unidadMedidaDTO)));
    }

    @Override
    public void delete(Long id_unidad_medida) {
        unidadMedidaRepository.deleteById(id_unidad_medida);
    }
}
