package com.bot.consultas.config;
import org.hibernate.dialect.OracleDialect;

public class TestDialect {
    public static void main(String[] args) {
        // Crear una instancia del dialecto OracleDialect (para versiones más recientes)
        OracleDialect dialect = new OracleDialect();
        
        // Imprimir el nombre de la clase del dialecto
        System.out.println("Dialect loaded: " + dialect.getClass().getName());
    }
}

