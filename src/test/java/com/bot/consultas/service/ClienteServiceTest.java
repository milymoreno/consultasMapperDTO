package com.bot.consultas.service;

import com.bot.consultas.mapper.ClienteMapper;
import com.bot.consultas.model.Cliente;
import com.bot.consultas.modelDTO.ClienteDTO;
import com.bot.consultas.repository.ClienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ClienteMapper clienteMapper;

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;
    private ClienteDTO clienteDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Ariana Eliette");

        clienteDTO = new ClienteDTO();
        clienteDTO.setId(1L);
        clienteDTO.setNombre("Ariana Eliette");
    }

    @Test
    void testCrearCliente() {
        when(clienteMapper.toEntity(any(ClienteDTO.class))).thenReturn(cliente);
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        when(clienteMapper.toDto(any(Cliente.class))).thenReturn(clienteDTO);

        ClienteDTO result = clienteService.crearCliente(clienteDTO);

        assertNotNull(result);
        assertEquals("Ariana Eliette", result.getNombre());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void testObtenerCliente() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(clienteMapper.toDto(any(Cliente.class))).thenReturn(clienteDTO);

        ClienteDTO result = clienteService.obtenerCliente(1L);

        assertNotNull(result);
        assertEquals("Ariana Eliette", result.getNombre());
        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    void testObtenerClientesPaginados() {
        List<Cliente> clientes = Arrays.asList(cliente);
        Page<Cliente> clientesPage = new PageImpl<>(clientes);
        Pageable pageable = PageRequest.of(0, 10);

        when(clienteRepository.findAll(pageable)).thenReturn(clientesPage);
        when(clienteMapper.toDto(any(Cliente.class))).thenReturn(clienteDTO);

        Page<ClienteDTO> result = clienteService.obtenerClientesPaginados(0, 10);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        verify(clienteRepository, times(1)).findAll(pageable);
    }

    @Test
    void testObtenerClientesPaginadosConCriteria() {
        // Configurar mocks para CriteriaBuilder y CriteriaQuery
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        CriteriaQuery<Cliente> criteriaQuery = mock(CriteriaQuery.class);
        Root<Cliente> clienteRoot = mock(Root.class);
        TypedQuery<Cliente> typedQuery = mock(TypedQuery.class);

        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Cliente.class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(Cliente.class)).thenReturn(clienteRoot);
        when(entityManager.createQuery(criteriaQuery)).thenReturn(typedQuery);

        // Simular resultados de la consulta
        List<Cliente> clientes = Arrays.asList(cliente);
        when(typedQuery.setFirstResult(anyInt())).thenReturn(typedQuery);
        when(typedQuery.setMaxResults(anyInt())).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(clientes);

        // Simular conteo de registros
        CriteriaQuery<Long> countQuery = mock(CriteriaQuery.class);
        TypedQuery<Long> countTypedQuery = mock(TypedQuery.class);

        when(criteriaBuilder.createQuery(Long.class)).thenReturn(countQuery);
        when(countQuery.from(Cliente.class)).thenReturn(clienteRoot);
        when(entityManager.createQuery(countQuery)).thenReturn(countTypedQuery);
        when(countTypedQuery.getSingleResult()).thenReturn(1L);

        Pageable pageable = PageRequest.of(0, 10);
        Page<Cliente> clientesPage = new PageImpl<>(clientes, pageable, 1L);

        when(clienteMapper.toDto(any(Cliente.class))).thenReturn(clienteDTO);

        Page<ClienteDTO> result = clienteService.obtenerClientesPaginadosConCriteria(0, 10, "Juan", null);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        verify(entityManager, times(1)).createQuery(criteriaQuery);
        verify(typedQuery, times(1)).setFirstResult(anyInt());
        verify(typedQuery, times(1)).setMaxResults(anyInt());
        verify(typedQuery, times(1)).getResultList();
    }

}

