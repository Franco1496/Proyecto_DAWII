package com.inmuebles24.mappers;

import com.inmuebles24.dtos.PropiedadDTO;
import com.inmuebles24.model.Propiedad;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PropiedadMapper {

    PropiedadMapper INSTANCE = Mappers.getMapper(PropiedadMapper.class);

    PropiedadDTO propiedadAPropiedadDTO(Propiedad propiedad);

    Propiedad propiedadDTOAPropiedad(PropiedadDTO propiedadDTO);

    List<PropiedadDTO> listaPropiedadAPropiedadDTO(List<Propiedad> propiedades);

    List<Propiedad> listaPropiedadDTOAPropiedad(List<PropiedadDTO> propiedadDTOS);

}
