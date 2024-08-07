package com.bot.consultas.service;

import com.bot.consultas.mapper.ClienteMapper;
import com.bot.consultas.model.Cliente;
import com.bot.consultas.modelDTO.ClienteDTO;
import com.bot.consultas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

//Nuevo icluyendo criteria

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    //Nuevo Criteria
    @PersistenceContext
    private EntityManager entityManager;
    
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

    // Nuevo método para obtener clientes paginados usando Criteria API
    public Page<ClienteDTO> obtenerClientesPaginadosConCriteria(int page, int size, String nombre, String descripcionTipoIdentificacion) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
        Root<Cliente> clienteRoot = criteriaQuery.from(Cliente.class);
        criteriaQuery.select(clienteRoot);

        // Agregar filtros usando Criteria API
        if (nombre != null && !nombre.isEmpty()) {
            criteriaQuery.where(criteriaBuilder.like(clienteRoot.get("nombre"), "%" + nombre + "%"));
        }

        // Filtro por descripción del tipo de identificación
        if (descripcionTipoIdentificacion != null && !descripcionTipoIdentificacion.isEmpty()) {
            Join<Object, Object> tipoIdentificacionJoin = clienteRoot.join("tipoIdentificacion");
            criteriaQuery.where(criteriaBuilder.like(tipoIdentificacionJoin.get("descripcion"), "%" + descripcionTipoIdentificacion + "%"));
        }

        // Aplicar paginación
        Pageable pageable = PageRequest.of(page, size);
        List<Cliente> clientes = entityManager.createQuery(criteriaQuery)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        // Contar el número total de registros
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Cliente> countRoot = countQuery.from(Cliente.class);
        countQuery.select(criteriaBuilder.count(countRoot));

        // Filtros para contar el número total de registros
        if (nombre != null && !nombre.isEmpty()) {
            countQuery.where(criteriaBuilder.like(countRoot.get("nombre"), "%" + nombre + "%"));
        }

        if (descripcionTipoIdentificacion != null && !descripcionTipoIdentificacion.isEmpty()) {
            Join<Object, Object> tipoIdentificacionJoin = countRoot.join("tipoIdentificacion");
            countQuery.where(criteriaBuilder.like(tipoIdentificacionJoin.get("descripcion"), "%" + descripcionTipoIdentificacion + "%"));
        }

        Long totalRecords = entityManager.createQuery(countQuery).getSingleResult();

        Page<Cliente> clientesPage = new PageImpl<>(clientes, pageable, totalRecords);
        return clientesPage.map(clienteMapper::toDto);
    }
    // Otros métodos del servicio según sea necesario...
}
