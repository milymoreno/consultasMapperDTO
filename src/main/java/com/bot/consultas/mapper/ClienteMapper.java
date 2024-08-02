package com.bot.consultas.mapper;

import com.bot.consultas.model.Cliente;
import com.bot.consultas.modelDTO.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
//import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(source = "numId", target = "numeroIdentificacion")
    @Mapping(source = "razonSocial", target = "razonSocial")
    @Mapping(source = "sigla", target = "sigla")
    @Mapping(source = "apellido1", target = "apellido1")
    @Mapping(source = "apellido2", target = "apellido2")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "entidadFinanciera", target = "entidadFinanciera")
    @Mapping(source = "tipoIdentificacion", target = "tipoIdentificacion")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "tipoCliente", target = "tipoCliente")
    @Mapping(source = "esFuentePago", target = "esFuentePago")
    @Mapping(source = "esDeudor", target = "esDeudor")
    ClienteDTO toDto(Cliente cliente);

    @Mapping(source = "numeroIdentificacion", target = "numId")
    @Mapping(source = "razonSocial", target = "razonSocial")
    @Mapping(source = "sigla", target = "sigla")
    @Mapping(source = "apellido1", target = "apellido1")
    @Mapping(source = "apellido2", target = "apellido2")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "entidadFinanciera", target = "entidadFinanciera")
    @Mapping(source = "tipoIdentificacion", target = "tipoIdentificacion")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "tipoCliente", target = "tipoCliente")
    @Mapping(source = "esFuentePago", target = "esFuentePago")
    @Mapping(source = "esDeudor", target = "esDeudor")
    Cliente toEntity(ClienteDTO clienteDTO);
}
