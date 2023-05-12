package com.inmuebles24.dtos;

import com.inmuebles24.model.Cliente;
import lombok.Data;
import java.sql.Time;
import java.util.Date;
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
