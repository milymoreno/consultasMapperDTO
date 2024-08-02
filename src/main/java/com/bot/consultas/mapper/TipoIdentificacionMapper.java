package com.bot.consultas.mapper;

import com.bot.consultas.model.TipoIdentificacion;
import com.bot.consultas.modelDTO.TipoIdentificacionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TipoIdentificacionMapper {

    TipoIdentificacionMapper INSTANCE = Mappers.getMapper(TipoIdentificacionMapper.class);

    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "descripcion", target = "descripcion")
    TipoIdentificacionDTO toDto(TipoIdentificacion tipoIdentificacion);

    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "descripcion", target = "descripcion")
    TipoIdentificacion toEntity(TipoIdentificacionDTO tipoIdentificacionDTO);
}
