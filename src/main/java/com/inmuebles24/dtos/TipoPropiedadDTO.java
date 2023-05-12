package com.inmuebles24.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class TipoPropiedadDTO {

    private long id_tipo_propiedad;
    private String tipo_propiedad;
    private Date fec_creacion;
    private boolean flag_estado;

}
