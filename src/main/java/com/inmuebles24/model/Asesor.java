package com.inmuebles24.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_asesor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Asesor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asesor;

    @Column(length =  100 ,nullable = false)
    private String nom_asesor;

    @Column(length =  100 ,nullable = false)
    private String ape_asesor;

    @Column(length =  20 ,nullable = false)
    private String tel_asesor;

    @Column(length =  100 ,nullable = false)
    private String correo_asesor;

    @Column(length =  100 ,nullable = false)
    private String pass_asesor;

    @Column(name = "fec_creacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    private Date fec_creacion;

    @Column(name = "flag_estado")
    private boolean flag_estado;

}
