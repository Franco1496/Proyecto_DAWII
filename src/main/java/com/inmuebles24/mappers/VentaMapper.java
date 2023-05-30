package com.inmuebles24.mappers;

import com.inmuebles24.dtos.VentaDTO;
import com.inmuebles24.model.Venta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VentaMapper {

    VentaMapper INSTANCE = Mappers.getMapper(VentaMapper.class);

    VentaDTO ventaAVentaDTO(Venta venta);

    Venta ventaDTOAVenta(VentaDTO ventaDTO);

    List<VentaDTO> listaVentaAVentaDTO(List<Venta> venta);

    List<Venta> listaVentaDTOAVenta(List<VentaDTO> ventaDTOLista);
}
