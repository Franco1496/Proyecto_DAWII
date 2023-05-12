package com.inmuebles24.dtos;

import com.inmuebles24.model.Cliente;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class CitaDTO {

    private long id_cita;
    private long id_propiedad_asesor;
    private Cliente id_cliente;
    private Date fec_cita;
    private Time hora_cita;
    private Date fec_creacion;
    private boolean flag_estado;
}
