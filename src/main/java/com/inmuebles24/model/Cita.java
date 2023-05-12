package com.inmuebles24.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "tb_cita")
@Data
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private long id_cita;


    @Column(name = "id_propiedad_asesor")
    private long id_propiedad_asesor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente" , nullable = false)
    private Cliente id_cliente;

    @Column(name = "fec_cita")
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fec_cita;

    @Column(name = "hora_cita")
    @Temporal(value = TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Time hora_cita;

    @Column(name = "fec_creacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    private Date fec_creacion;

    @Column(name = "flag_estado")
    private boolean flag_estado;
}