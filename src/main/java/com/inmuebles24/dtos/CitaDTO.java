package com.inmuebles24.dtos;

import com.inmuebles24.model.Cliente;
import com.inmuebles24.model.Propiedad_asesor;
import lombok.Data;

import java.sql.Date;
import java.time.LocalTime;


@Data
public class CitaDTO {

    private long id_cita;
    private Propiedad_asesorDTO id_propiedad_asesor;
    private ClienteDTO id_cliente;
    private Date fec_cita;
    private String hora_cita;
    private Date fec_creacion;
    private boolean flag_estado;
}
