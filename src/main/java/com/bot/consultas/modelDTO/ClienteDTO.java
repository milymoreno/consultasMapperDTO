package com.bot.consultas.modelDTO;

import com.bot.consultas.model.enums.EnumEstadoEntidad;
import com.bot.consultas.model.enums.EnumTipoCliente;
import lombok.Data;


@Data
public class ClienteDTO {
    //private static final long serialVersionUID = 1L;

    private Long id;
    private String numeroIdentificacion;
    private String razonSocial;
    private String sigla;
    private String nombre;
    private String apellido1;	
    private String apellido2;    
    private EntidadFinancieraDTO entidadFinanciera;
    private TipoIdentificacionDTO tipoIdentificacion;
    private EnumEstadoEntidad estado;
    private EnumTipoCliente tipoCliente;	
    private Boolean esFuentePago;
    private Boolean esDeudor;

    public ClienteDTO() {}
}
