package com.inmuebles24.service.impl;

import com.inmuebles24.dtos.VentaDTO;
import com.inmuebles24.mappers.VentaMapper;
import com.inmuebles24.model.Cliente;
import com.inmuebles24.model.Venta;
import com.inmuebles24.repository.VentaRepository;
import com.inmuebles24.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    private VentaMapper ventaMapper = VentaMapper.INSTANCE;


    @Override
    public VentaDTO find(Long id_venta) {
        Optional<Venta> venta = ventaRepository.findById(id_venta);
        if (venta.isPresent()) {
            return ventaMapper.ventaAVentaDTO(venta.get());
        }
        throw new RuntimeException();
    }

    @Override
    public List<VentaDTO> findAll() {
        return ventaMapper.listaVentaAVentaDTO(ventaRepository.findAll());
    }

    @Override
    public VentaDTO save(VentaDTO ventaDTO) {
        return ventaMapper.ventaAVentaDTO(ventaRepository.save(ventaMapper.ventaDTOAVenta(ventaDTO)));
    }

    @Override
    public void delete(Long id_venta) {
        ventaRepository.deleteById(id_venta);

    }
}
