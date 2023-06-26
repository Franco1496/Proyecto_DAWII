package com.inmuebles24.mappers;

import com.inmuebles24.dtos.CitaDTO;
import com.inmuebles24.model.Cita;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CitaMapper {

    CitaMapper INSTANCE = Mappers.getMapper(CitaMapper.class);

    CitaDTO citaACitaDTO(Cita cita);

    Cita citaDTOACita( CitaDTO citaDTO);

    List<CitaDTO>  listaCitaACitaDTO(List<Cita> cita);

    List<Cita> listaCitaDTOACita(List<CitaDTO> citaDTOLista);


}
