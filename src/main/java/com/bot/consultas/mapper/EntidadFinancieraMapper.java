package com.bot.consultas.mapper;

import com.bot.consultas.model.EntidadFinanciera;
import com.bot.consultas.modelDTO.EntidadFinancieraDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EntidadFinancieraMapper {

    EntidadFinancieraMapper INSTANCE = Mappers.getMapper(EntidadFinancieraMapper.class);

    @Mapping(source = "numId", target = "numeroIdentificacion")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "razonSocial", target = "razonSocial")
    @Mapping(source = "porDctoDev", target = "porDctoDev")
    EntidadFinancieraDTO toDto(EntidadFinanciera entidadFinanciera);

    @Mapping(source = "numeroIdentificacion", target = "numId")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "razonSocial", target = "razonSocial")
    @Mapping(source = "porDctoDev", target = "porDctoDev")
    EntidadFinanciera toEntity(EntidadFinancieraDTO entidadFinancieraDTO);
}
