package com.inmuebles24.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ubigeo")
@Data
public class Ubigeo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubigeo")
    private long id_ubigeo;

    @Column(name = "ubigeo", length = 6)
    private String ubigeo;

    @Column(name = "cod_departamento", length = 2)
    private String cod_departamento;

    @Column(name = "departamento", length = 30)
    private String departamento;

    @Column(name = "cod_provincia", length = 2)
    private String cod_provincia;

    @Column(name = "provincia", length = 30)
    private String provincia;

    @Column(name = "cod_distrito", length = 2)
    private String cod_distrito;

    @Column(name = "distrito", length = 40)
    private String distrito;

    @Column(name = "fec_creacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    private Date fec_creacion;

    @Column(name = "flag_estado")
    private boolean flag_estado;
}
