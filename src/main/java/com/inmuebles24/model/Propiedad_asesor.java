package com.inmuebles24.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "propiedad_asesor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Propiedad_asesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_propiedad_asesor;

  //  @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "id_propiedad", nullable = false)


     @Column(name = "id_propiedad" )
     private Long id_propiedad;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_asesor", nullable = false)
    private Asesor id_asesor;


    @Column(name = "fec_creacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    private Date fec_creacion;

    @Column(name = "flag_estado")
    private boolean flag_estado;


}
