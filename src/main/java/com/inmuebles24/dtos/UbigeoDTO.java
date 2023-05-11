package com.inmuebles24.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class UbigeoDTO {
    private long id_ubigeo;
    private String ubigeo;
    private String cod_departamento;
    private String departamento;
    private String cod_provincia;
    private String provincia;
    private String cod_distrito;
    private String distrito;
    private Date fec_creacion;
    private boolean flag_estado;
}
