package com.inmuebles24.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class ClienteDTO {
    private long id_cliente;
    private String documento;
    private String nom_cliente;
    private String ape_cliente;
    private String dir_cliente;
    private UbigeoDTO id_ubigeo;
    private String tel_cliente;
    private String correo_cliente;
    private Date fec_creacion;
    private boolean flag_estado;
}
