package com.bot.consultas.service;

import com.bot.consultas.mapper.ClienteMapper;
import com.bot.consultas.model.Cliente;
import com.bot.consultas.modelDTO.ClienteDTO;
import com.bot.consultas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/*import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.Join;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.validation.constraints.NotNull;
import jakarta.annotation.Nullable;*/

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

    public Page<ClienteDTO> obtenerClientesPaginados(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Cliente> clientesPage = clienteRepository.findAll(pageable);
        return clientesPage.map(clienteMapper::toDto);
    }
    // Otros métodos del servicio según sea necesario...
}
