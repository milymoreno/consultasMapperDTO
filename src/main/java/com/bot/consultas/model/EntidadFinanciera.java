package com.bot.consultas.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ENTIDADFINANCIERA")
public class EntidadFinanciera implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
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

	