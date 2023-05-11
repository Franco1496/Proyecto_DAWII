package com.inmuebles24.mappers;

import com.inmuebles24.dtos.UbigeoDTO;
import com.inmuebles24.model.Ubigeo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UbigeoMapper {
    UbigeoMapper INSTANCE = Mappers.getMapper(UbigeoMapper.class);

    UbigeoDTO ubigeoAUbigeoDTO(Ubigeo ubigeo);

    Ubigeo ubigeoDTOAUbigeo(UbigeoDTO ubigeoDTO);

    List<UbigeoDTO> listaUbigeoAUbigeoDTO(List<Ubigeo> ubigeo);

    List<Ubigeo> listaUbigeoDTOAUbigeo(List<UbigeoDTO> ubigeoDTOLista);
}
