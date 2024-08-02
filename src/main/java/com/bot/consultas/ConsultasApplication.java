package com.bot.consultas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bot.consultas.service", "com.bot.consultas.mapper", "com.bot.consultas.controller","com.bot.consultas.modelDTO"})
public class ConsultasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultasApplication.class, args);
	}

}
