package com.inmuebles24.service.impl;

import com.inmuebles24.dtos.PropiedadDTO;
import com.inmuebles24.mappers.PropiedadMapper;
import com.inmuebles24.model.Propiedad;
import com.inmuebles24.repository.PropiedadRepository;
import com.inmuebles24.service.PropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropiedadServiceImpl implements PropiedadService {

    @Autowired
    PropiedadRepository repo;

    private PropiedadMapper mapper = PropiedadMapper.INSTANCE;

    @Override
    public PropiedadDTO find(Long id_propiedad) {
        Optional<Propiedad> propiedad = repo.findById(id_propiedad);
        if (propiedad.isPresent()){
            return mapper.propiedadAPropiedadDTO(propiedad.get());
        }

        throw  new RuntimeException();
    }

    @Override
    public List<PropiedadDTO> findAll() {
        return mapper.listaPropiedadAPropiedadDTO(repo.findAll());
    }

    @Override
    public PropiedadDTO save(PropiedadDTO propiedadDTO) {
        return mapper.propiedadAPropiedadDTO(repo.save(mapper.propiedadDTOAPropiedad(propiedadDTO)));
    }

    @Override
    public void delete(Long id_propiedad) {
        repo.deleteById(id_propiedad);
    }
}
