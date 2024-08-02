package com.bot.consultas.modelDTO;

import lombok.Data;

@Data
public class EntidadFinancieraDTO {

    private Long id;

	private String numeroIdentificacion;

	private String nombre;

	private String razonSocial;

	private Double porDctoDev;

}
