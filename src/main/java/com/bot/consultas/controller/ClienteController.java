package com.bot.consultas.controller;

import com.bot.consultas.modelDTO.ClienteDTO;
import com.bot.consultas.response.ClienteResponse;
import com.bot.consultas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> crearCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO nuevoClienteDTO = clienteService.crearCliente(clienteDTO);
        return ResponseEntity.ok(nuevoClienteDTO);
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtenerCliente(@PathVariable Long id) {
        ClienteDTO clienteDTO = clienteService.obtenerCliente(id);
        return ResponseEntity.ok(clienteDTO);
    }*/

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteDTO> obtenerCliente(@PathVariable Long id) {
        ClienteDTO clienteDTO = clienteService.obtenerCliente(id);
       // Verifica si clienteDTO no es null antes de acceder a sus métodos
        if (clienteDTO != null) {
            System.out.println("ID: " + clienteDTO.getId());
            System.out.println("Numero Identificacion: " + clienteDTO.getNumeroIdentificacion());
            System.out.println("Razon Social: " + clienteDTO.getRazonSocial());
        }
        return ResponseEntity.ok(clienteDTO);
    }

    @GetMapping("/clientes")
    public Page<ClienteDTO> obtenerClientesPaginados(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
        return clienteService.obtenerClientesPaginados(page, size);
    }

    @GetMapping("/clientesCriteriaNativo")
    public ResponseEntity<Page<ClienteDTO>> getClientesPaginatedNativo(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String descripcionTipoIdentificacion) {
        Page<ClienteDTO> clientes = clienteService.obtenerClientesPaginadosConCriteria(page, size, nombre, descripcionTipoIdentificacion);
        return ResponseEntity.ok(clientes);
    }

    //clientes paginados con page y respuest personalizada
    @GetMapping("/clientesCriteria")
    public ResponseEntity<ClienteResponse> getClientesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String descripcionTipoIdentificacion) {

        Page<ClienteDTO> clientesPage = clienteService.obtenerClientesPaginadosConCriteria(page, size, nombre, descripcionTipoIdentificacion);

         // Construir la respuesta personalizada
         ClienteResponse response = new ClienteResponse();
         response.setMensaje("Operación exitosa");
         response.setNroTotalRegistros(clientesPage.getTotalElements());
         response.setExitoso(true);
         response.setDatos(clientesPage.getContent()); 

        return ResponseEntity.ok(response);
    }

    // Otros endpoints...
}
