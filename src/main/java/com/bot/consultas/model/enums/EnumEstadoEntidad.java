package com.bot.consultas.model.enums;

public enum EnumEstadoEntidad {
    /**
     * Para entidades en estado Habilitado
     */
    HABILITADO("ENM.ESTENT.1"),
    /**
     * Para entidades en estado Deshabilitado
     */
    DESHABILITADO("ENM.ESTENT.2"),
    /**
     * Para entidades en Proceso de Corrección
     */
    PROCESOCORRECCION("ENM.ESTENT.3"),
    /**
     * Para entidades en Estado Eliminado
     */
    ELIMINADO("ENM.ESTENT.4"),
    /**
     * Para entidades en Estado Pendiente de Creacion
     */
    PENDIENTE_CREACION("ENM.ESTENT.5"),
    /**
     * Para entidades en Estado Proceso de Autorizacion
     */
    PROCESOAUTORIZACION("ENM.ESTENT.6"),
    /**
     * Para entidades en Estado Autorizado
     */
    AUTORIZADO("ENM.ESTENT.7"),
    /**
     * Para entidades en Estado Rechazado
     */
    RECHAZADO("ENM.ESTENT.8"),
    /**
     * Para entidades en Estado en proceso de cargue
     */
    EN_PROCESO_CARGUE("ENM.ESTENT.9"),
    /**
     * Inicialmente para planes LT
     */
    EN_PROCESO_MODELACION("ENM.ESTENT.10"),

    /**
    * Inicialmente para planes LT
    */
    ACTIVO_CONTROL("ENM.ESTENT.11"),
    
    /**
     * Para entidades en Estado Inactivo
     */
     INACTIVO("ENM.ESTENT.12"),
     
     /**
      * Para estado pendiente de encuesta.
      */
     PENDIENTEENCUESTA("ENM.ESTENT.13"),
      /**
      * Para encuestas incorrectas
      */
     ENCUESTAINCORRECTA("ENM.ESTENT.14"),
     
     /**
      * Para Identificar Usuarios Modificados
      */
      MODIFICADO("ENM.ESTENT.15"),
    
    /**
     * Pendiente Notificacion
     */
    PENDIENTE_NOTIFICACION("ENM.ESTENT.16"),
    
    /**
     * Pendiente Encuesta Automatica
     */
    PENDIENTE_ENCUESTA_AUT("ENM.ESTENT.17"),
    
    /**
     * Pendiente activacion token
     */
    PENDIENTE_ACT_TOKEN("ENM.ESTENT.18"),
    
    /**
     * Reversado
     */
    REVERSADO("ENM.ESTENT.19");
    

    /**
     * Código para el mensaje de internacionalización
     */
    private final String codMessg;

    /**
     * Constructor para el enum "Estados Entidad"
     * 
     * @param codMes
     *                Es el código para el mensaje de internacionalización
     */
    private EnumEstadoEntidad(String codMes) {
        this.codMessg = codMes;
    }

    /**
     * Retorna el código del mensaje de internacionalización para los
     * estados de las Entidades
     * 
     * @return codMessg Código de internacionalización
     */
    public String getCodMessg() {
        return codMessg;
    }
}
