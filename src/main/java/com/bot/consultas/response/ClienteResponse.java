package com.bot.consultas.response;

import java.util.List;
import com.bot.consultas.modelDTO.ClienteDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ClienteResponse extends ResponseBody {
    private List<ClienteDTO> datos;
}

