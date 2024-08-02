package com.bot.consultas.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import com.bot.consultas.model.Cliente;
import com.bot.consultas.model.enums.EnumEstadoEntidad;
import com.bot.consultas.model.enums.EnumTipoCliente;

@SpringBootTest
public class ClienteTests {

    @Test
    public void testGettersSetters() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNumId("1020846521");
        cliente.setRazonSocial("Razón Social");
        cliente.setSigla("RS");
        cliente.setNombre("Mildred Maria");
        cliente.setApellido1("Moreno");
        cliente.setApellido2("Liscano");
        cliente.setEstado(EnumEstadoEntidad.HABILITADO);
        cliente.setTipoCliente(EnumTipoCliente.NATURAL);
        cliente.setEsFuentePago(true);
        cliente.setEsDeudor(false);

        assertEquals(1L, cliente.getId());
        assertEquals("1020846521", cliente.getNumId());
        assertEquals("Razón Social", cliente.getRazonSocial());
        assertEquals("RS", cliente.getSigla());
        assertEquals("Mildred Maria", cliente.getNombre());
        assertEquals("Moreno", cliente.getApellido1());
        assertEquals("Liscano", cliente.getApellido2());
        assertEquals(EnumEstadoEntidad.HABILITADO, cliente.getEstado());
        assertEquals(EnumTipoCliente.NATURAL, cliente.getTipoCliente());
        assertEquals(true, cliente.getEsFuentePago());
        assertEquals(false, cliente.getEsDeudor());
    }
}
