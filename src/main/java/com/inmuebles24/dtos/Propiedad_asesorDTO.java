package com.inmuebles24.dtos;

import com.inmuebles24.model.Asesor;
import lombok.Data;


import java.util.Date;

@Data
public class Propiedad_asesorDTO {

    private Long id_propiedad_asesor;
    private Long id_propiedad;
    private AsesorDTO id_asesor;
    private Date fec_creacion;
    private boolean flag_estado;
}
