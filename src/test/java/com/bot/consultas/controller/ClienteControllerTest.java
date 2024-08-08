package com.bot.consultas.controller;

import com.bot.consultas.modelDTO.ClienteDTO;
import com.bot.consultas.response.ClienteResponse;
import com.bot.consultas.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    private ClienteDTO clienteDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clienteDTO = new ClienteDTO();
        clienteDTO.setId(1L);
        clienteDTO.setNombre("Juan");
        clienteDTO.setNumeroIdentificacion("12345678");
        clienteDTO.setRazonSocial("Razon Social S.A.");
    }

    @Test
    void testCrearCliente() throws Exception {
        when(clienteService.crearCliente(any(ClienteDTO.class))).thenReturn(clienteDTO);

        mockMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Juan\",\"numeroIdentificacion\":\"12345678\",\"razonSocial\":\"Razon Social S.A.\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Juan")))
                .andExpect(jsonPath("$.numeroIdentificacion", is("12345678")))
                .andExpect(jsonPath("$.razonSocial", is("Razon Social S.A.")));
    }

    @Test
    void testObtenerCliente() throws Exception {
        when(clienteService.obtenerCliente(anyLong())).thenReturn(clienteDTO);

        mockMvc.perform(get("/clientes/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nombre", is("Juan")))
                .andExpect(jsonPath("$.numeroIdentificacion", is("12345678")))
                .andExpect(jsonPath("$.razonSocial", is("Razon Social S.A.")));
    }

    @Test
    void testObtenerClientesPaginados() throws Exception {
        List<ClienteDTO> clientes = Arrays.asList(clienteDTO);
        Page<ClienteDTO> clientesPage = new PageImpl<>(clientes);
        when(clienteService.obtenerClientesPaginados(anyInt(), anyInt())).thenReturn(clientesPage);

        mockMvc.perform(get("/clientes/clientes")
                .param("page", "0")
                .param("size", "10")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(1)))
                .andExpect(jsonPath("$.content[0].nombre", is("Juan")));
    }

    @Test
    void testGetClientesPaginatedNativo() throws Exception {
        List<ClienteDTO> clientes = Arrays.asList(clienteDTO);
        Page<ClienteDTO> clientesPage = new PageImpl<>(clientes);
        when(clienteService.obtenerClientesPaginadosConCriteria(anyInt(), anyInt(), any(), any())).thenReturn(clientesPage);

        mockMvc.perform(get("/clientes/clientesCriteriaNativo")
                .param("page", "0")
                .param("size", "10")
                .param("nombre", "Juan")
                .param("descripcionTipoIdentificacion", "Descripcion")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(1)))
                .andExpect(jsonPath("$.content[0].nombre", is("Juan")));
    }

    @Test
    void testGetClientesPaginated() throws Exception {
        List<ClienteDTO> clientes = Arrays.asList(clienteDTO);
        Page<ClienteDTO> clientesPage = new PageImpl<>(clientes);
        when(clienteService.obtenerClientesPaginadosConCriteria(anyInt(), anyInt(), any(), any())).thenReturn(clientesPage);

        mockMvc.perform(get("/clientes/clientesCriteria")
                .param("page", "0")
                .param("size", "10")
                .param("nombre", "Juan")
                .param("descripcionTipoIdentificacion", "Descripcion")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.datos", hasSize(1)))
                .andExpect(jsonPath("$.datos[0].nombre", is("Juan")))
                .andExpect(jsonPath("$.mensaje", is("Operación exitosa")))
                .andExpect(jsonPath("$.nroTotalRegistros", is(1)))
                .andExpect(jsonPath("$.exitoso", is(true)));
    }
}
