package com.bot.consultas.response;

import com.fasterxml.jackson.annotation.JsonSubTypes;

import lombok.Data;

@JsonSubTypes({ 
        @JsonSubTypes.Type(value = TipoIdentificacionResponse.class, name = "success"),
        @JsonSubTypes.Type(value = ClienteResponse.class, name = "success"),
        /*@JsonSubTypes.Type(value = TipoTasaResponse.class, name = "success"),
        @JsonSubTypes.Type(value = ParametrosResponse.class, name = "success"),
        */
})
@Data
public abstract class ResponseBody {

	String mensaje;
	Long nroTotalRegistros;
	boolean exitoso;

}
