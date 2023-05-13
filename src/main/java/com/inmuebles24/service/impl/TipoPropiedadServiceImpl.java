package com.inmuebles24.service.impl;

import com.inmuebles24.dtos.TipoPropiedadDTO;
import com.inmuebles24.mappers.TipoPropiedadMapper;
import com.inmuebles24.model.TipoPropiedad;
import com.inmuebles24.repository.TipoPropiedadRepository;
import com.inmuebles24.service.TipoPropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPropiedadServiceImpl implements TipoPropiedadService {

    @Autowired
    private TipoPropiedadRepository tipoPropiedadRepository;

    private TipoPropiedadMapper tipoPropiedadMapper = TipoPropiedadMapper.INSTANCE;

    @Override
    public TipoPropiedadDTO find(Long id_tipo_propiedad) {
        Optional<TipoPropiedad> tipoPropiedad =tipoPropiedadRepository.findById(id_tipo_propiedad);
        if (tipoPropiedad.isPresent()){
            return tipoPropiedadMapper.tipoPropiedadATipoPropiedadDTO(tipoPropiedad.get());
        }
        throw new RuntimeException();
    }

    @Override
    public List<TipoPropiedadDTO> findAll() {
        return tipoPropiedadMapper.listaTipoPropiedadATipoPropiedadDTO(tipoPropiedadRepository.findAll());
    }

    @Override
    public TipoPropiedadDTO save(TipoPropiedadDTO tipoPropiedadDTO) {
        return tipoPropiedadMapper.tipoPropiedadATipoPropiedadDTO(tipoPropiedadRepository.save(tipoPropiedadMapper.tipoPropiedadDTOATipoPropiedad(tipoPropiedadDTO)));
    }

    @Override
    public void delete(Long id_tipo_propiedad) {
        tipoPropiedadRepository.deleteById(id_tipo_propiedad);
    }
}
