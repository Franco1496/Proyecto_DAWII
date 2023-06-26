package com.inmuebles24.dtos;

import com.inmuebles24.model.Cliente;
import com.inmuebles24.model.Propiedad_asesor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class VentaDTO {

    private long id_venta;
    private Propiedad_asesorDTO id_propiedad_asesor;
    private ClienteDTO id_cliente;
    private BigDecimal monto_venta;
    private Date fec_creacion;
    private boolean flag_estado;
}
