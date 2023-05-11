package com.inmuebles24.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private long id_cliente;

    @Column(name = "documento", length = 11)
    private String documento;

    @Column(name = "nom_cliente", length = 100)
    private String nom_cliente;

    @Column(name = "ape_cliente", length = 100)
    private String ape_cliente;

    @Column(name = "dir_cliente", length = 100)
    private String dir_cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubigeo", nullable = false)
    private Ubigeo id_ubigeo;

    @Column(name = "tel_cliente", length = 9)
    private String tel_cliente;

    @Column(name = "correo_cliente", length = 100)
    private String correo_cliente;

    @Column(name = "fec_creacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    private Date fec_creacion;

    @Column(name = "flag_estado")
    private boolean flag_estado;
}
