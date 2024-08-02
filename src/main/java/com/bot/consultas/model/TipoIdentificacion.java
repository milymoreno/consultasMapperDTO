package com.bot.consultas.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TIDENT")
public class TipoIdentificacion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * @todo add comment for javadoc
	 */
	
	private Long codigo;

	/**
	 * @todo add comment for javadoc
	 */
	
	private String descripcion;

}