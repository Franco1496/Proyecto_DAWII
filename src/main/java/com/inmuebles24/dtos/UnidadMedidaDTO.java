package com.inmuebles24.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class UnidadMedidaDTO {

    private long id_unidad_medida;
    private String unidad_medida;
    private Date fec_creacion;
    private boolean flag_estado;

}
