package com.inmuebles24.dtos;

import com.inmuebles24.model.Cliente;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class VentaDTO {

    private long id_venta;
    private long id_propiedad_asesor;
    private Cliente id_cliente;
    private BigDecimal monto_venta;
    private Date fec_creacion;
    private boolean flag_estado;
}
