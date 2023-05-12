package com.inmuebles24.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "unidadMedida")
@Data
public class UnidadMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unidad_medida")
    private long id_unidad_medida;

    @Column(name = "unidad_medida", length = 100)
    private String unidad_medida;

    @Column(name = "fec_creacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    private Date fec_creacion;

    @Column(name = "flag_estado")
    private boolean flag_estado;

}
