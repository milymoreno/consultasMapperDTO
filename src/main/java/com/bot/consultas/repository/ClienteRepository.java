package com.bot.consultas.repository;

import com.bot.consultas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
/* 
public interface ClienteRepository extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {
}
*/