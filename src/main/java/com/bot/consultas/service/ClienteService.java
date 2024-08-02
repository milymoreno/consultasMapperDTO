package com.bot.consultas.service;

import com.bot.consultas.mapper.ClienteMapper;
import com.bot.consultas.model.Cliente;
import com.bot.consultas.modelDTO.ClienteDTO;
import com.bot.consultas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        Cliente nuevoCliente = clienteRepository.save(cliente);
        return clienteMapper.toDto(nuevoCliente);
    }

    public ClienteDTO obtenerCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
                System.out.println("Cliente recuperado: " + cliente); // Depuración
        return clienteMapper.toDto(cliente);
    }

    // Otros métodos del servicio según sea necesario...
}
