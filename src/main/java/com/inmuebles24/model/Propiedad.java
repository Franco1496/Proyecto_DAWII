package com.inmuebles24.model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_propiedad")
@Data
public class Propiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_propiedad")
    private Long idPropiedad;

    @Column(name = "dir_propiedad")
    private String direccionPropiedad;

    @ManyToOne
    @JoinColumn(name = "id_ubigeo", nullable = false)
    private Ubigeo idUbigeo;


    @ManyToOne
    @JoinColumn(name = "id_tipo_propiedad", nullable = false)
    private TipoPropiedad idTipoPropiedad;

    @Column(name = "cant_habitaciones")
    private int cantidadHabitaciones;

    @Column(name = "cant_banhos")
    private int cantidadBanhos;

    @Column(name = "area_total")
    private int areaTotal;


    @ManyToOne
    @JoinColumn(name = "id_unidad_medida", nullable = false)
    private UnidadMedida idUnidadMedida;

    @Column(name = "precio_venta")
    private double precioVenta;

    @Column(name = "disponible_venta")
    private boolean disponibleVenta;
    @Column(name = "fec_creacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    private Date fechaCreacion;
    @Column(name = "flag_estado")
    private boolean flagEstado;
}
