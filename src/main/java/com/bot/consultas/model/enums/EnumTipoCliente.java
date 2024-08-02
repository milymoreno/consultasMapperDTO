package com.bot.consultas.model.enums;

/**
 * Representa los tipos de cliente del sistema
 * @author Administrador
 *
 */
public enum EnumTipoCliente {

	/** Tipo cliente natural*/
	NATURAL("ENM.TCLI.1"),
	/** Tipo cliente juridico*/
	JURIDICO("ENM.TCLI.2");
	
	   /**
     * Código para el mensaje de internacionalización
     */
    private final String codMessg;

    /**
     * Constructor para un valor de una enumeracion
     * 
     * @param codMes
     *                Es el código para el mensaje de internacionalización
     */
    private EnumTipoCliente(String codMes) {
        this.codMessg = codMes;
    }

    /**
     * Retorna el código del mensaje de internacionalización para el valor del
     * elemento de la enumeracion
     * 
     * @return codMessg Código de internacionalización
     */
    public String getCodMessg() {
        return codMessg;
    }
	
}

