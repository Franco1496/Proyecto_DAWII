package com.inmuebles24.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class PropiedadDTO {

    private int idPropiedad;

    private String direccionPropiedad;

    private UbigeoDTO idUbigeo;

    private TipoPropiedadDTO idTipoPropiedad;

    private int cantidadHabitaciones;
    private int cantidadBanhos;
    private int areaTotal;
    private UnidadMedidaDTO idUnidadMedida;
    private double precioVenta;
    private boolean disponibleVenta;
    private Date fechaCreacion;
    private boolean flagEstado;
}
