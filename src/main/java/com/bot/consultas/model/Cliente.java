package com.bot.consultas.model;

import java.io.Serializable;

import com.bot.consultas.model.enums.EnumEstadoEntidad;
import com.bot.consultas.model.enums.EnumTipoCliente;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CLIENTE")

/**
 * Persona natural o jurídica que realiza negocios de Factoring a través de una
 * Entidad Financiera
 */

public class Cliente implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name = "NUMID")
	private String numId;

	@Column(name = "RAZONSOCIAL")
	private String razonSocial;

	@Column(name = "SIGLA")
	private String sigla;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "APELLIDO1")
	private String apellido1;

	@Column(name = "APELLIDO2")
	private String apellido2;

	@JoinColumn(name = "ENTIDADFINANCIERA_ID")
	@ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private EntidadFinanciera entidadFinanciera;

	@JoinColumn(name = "TIPOIDENTIFICACION_ID")
	@ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private TipoIdentificacion tipoIdentificacion;

	@Column(name = "ESTADO")
	@Enumerated(value = EnumType.ORDINAL)
	private EnumEstadoEntidad estado;

	@Column(name = "TIPOCLIENTE")
	@Enumerated(value = EnumType.ORDINAL)
	private EnumTipoCliente tipoCliente;

	@Column(name = "ESFUENTEPAGO")
	private Boolean esFuentePago;

	@Column(name = "ESDEUDOR")
	private Boolean esDeudor;

	public Cliente() {}


}
