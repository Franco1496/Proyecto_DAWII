package com.inmuebles24.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalTime;
import java.util.Date;




@Entity
@Table(name = "tb_cita")
@Data
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private long id_cita;


    @ManyToOne
    @JoinColumn(name = "id_propiedad_asesor", nullable = false)
    private Propiedad_asesor id_propiedad_asesor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente" , nullable = false)
    private Cliente id_cliente;

    @Column(name = "fec_cita")
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fec_cita;

    @Column(name = "hora_cita")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private String hora_cita;

    @Column(name = "fec_creacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    private Date fec_creacion;

    @Column(name = "flag_estado")
    private boolean flag_estado;
}