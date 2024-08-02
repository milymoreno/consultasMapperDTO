package com.bot.consultas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "ENTIDADFINANCIERA")
public class EntidadFinanciera {

	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NUMID")
	private String numId;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "RAZONSOCIAL")
	private String razonSocial;
	
	
	@Column(name = "PORDCTODEV", columnDefinition = "NUMBER(9,6)")
	private Double porDctoDev;

	
}

