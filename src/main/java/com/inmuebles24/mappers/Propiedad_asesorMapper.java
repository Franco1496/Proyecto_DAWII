package com.inmuebles24.mappers;

import com.inmuebles24.dtos.Propiedad_asesorDTO;
import com.inmuebles24.model.Propiedad_asesor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface Propiedad_asesorMapper {

    Propiedad_asesorMapper INSTANCE = Mappers.getMapper(Propiedad_asesorMapper.class);

    Propiedad_asesorDTO propiedad_asesorAPropiedad_asesorDTO(Propiedad_asesor propiedad_asesor);

    Propiedad_asesor propiedad_asesorDTOAPropiedad_asesor(Propiedad_asesorDTO propiedad_asesorDTO);

    List<Propiedad_asesorDTO> listaPropiedad_asesorAPropiedad_asesorDTO(List<Propiedad_asesor> propiedad_asesor);

    List<Propiedad_asesor> listaPropiedad_asesorDTOAPropiedad_asesor(List<Propiedad_asesorDTO> propiedad_asesorDTOLista);


}
