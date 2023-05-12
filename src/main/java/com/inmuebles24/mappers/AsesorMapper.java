package com.inmuebles24.mappers;


import com.inmuebles24.dtos.AsesorDTO;
import com.inmuebles24.model.Asesor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AsesorMapper {

    AsesorMapper INSTANCIA = Mappers.getMapper(AsesorMapper.class);

    AsesorDTO asesorAAsesorDTO(Asesor asesor);
    Asesor asesorDTOAAsesor(AsesorDTO asesorDTO);
    List<AsesorDTO> listaClienteAAsesorDTO(List<Asesor> asesor);

    List<Asesor> listaAsesorDTOAAsesor(List<AsesorDTO> asesorDTOList);
}
