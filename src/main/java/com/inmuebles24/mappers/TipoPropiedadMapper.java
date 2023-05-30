package com.inmuebles24.mappers;

import com.inmuebles24.dtos.TipoPropiedadDTO;
import com.inmuebles24.model.TipoPropiedad;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TipoPropiedadMapper {

    TipoPropiedadMapper INSTANCE = Mappers.getMapper(TipoPropiedadMapper.class);

    TipoPropiedadDTO tipoPropiedadATipoPropiedadDTO(TipoPropiedad tipoPropiedad);

    TipoPropiedad tipoPropiedadDTOATipoPropiedad(TipoPropiedadDTO tipoPropiedadDTO);

    List<TipoPropiedadDTO> listaTipoPropiedadATipoPropiedadDTO(List<TipoPropiedad> tipoPropiedad);

    List<TipoPropiedad> listaTipoPropiedadDTOATipoPropiedad(List<TipoPropiedadDTO> tipoPropiedadDTOLista);



}
