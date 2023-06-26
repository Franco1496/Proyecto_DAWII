package com.inmuebles24.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AsesorDTO {

    private Long id_asesor;
    private String nom_asesor;
    private String ape_asesor;
    private String tel_asesor;
    private String correo_asesor;
    private String pass_asesor;
    private Date fec_creacion;
    private boolean flag_estado;

}
