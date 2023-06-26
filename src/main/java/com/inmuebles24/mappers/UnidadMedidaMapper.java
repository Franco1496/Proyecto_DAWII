package com.inmuebles24.mappers;

import com.inmuebles24.dtos.UnidadMedidaDTO;
import com.inmuebles24.model.UnidadMedida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UnidadMedidaMapper {

    UnidadMedidaMapper INSTANCE = Mappers.getMapper(UnidadMedidaMapper.class);

    UnidadMedidaDTO unidadMedidaAUnidadMedidaDTO(UnidadMedida unidadMedida);

    UnidadMedida unidadMedidaDTOAUnidadMedida(UnidadMedidaDTO unidadMedidaDTO);

    List<UnidadMedidaDTO> listaUnidadMedidaAUnidadMedidaDTO(List<UnidadMedida> unidadMedida);

    List<UnidadMedida> listaUnidadMedidaDTOAUnidadMedida(List<UnidadMedidaDTO> unidadMedidaDTOLista);

}
