package com.inmuebles24.dtos;

import com.inmuebles24.model.Asesor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Propiedad_asesorDTO {

    private Long id_propiedad_asesor;
    private Long id_propiedad;
    private Asesor id_asesor;
    private Date fec_creacion;
    private boolean flag_estado;
}
