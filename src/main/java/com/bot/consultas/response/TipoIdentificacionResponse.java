package com.bot.consultas.response;
import java.util.List;
import com.bot.consultas.modelDTO.TipoIdentificacionDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoIdentificacionResponse extends ResponseBody {

	List<TipoIdentificacionDTO> datos;

	/*public List<TipoIdentificacionDTO> getDatos() {
		return datos;
	}

	public void setDatos(List<TipoIdentificacionDTO> datos) {
		this.datos = datos;
	}*/
	
}
