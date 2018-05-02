package com.coffee.back.controller;

/**
 * La interfaz {@code Report} es encargada de recibir las peticiones lanzadas
 * por el usuario desde la vista, se encarga de manejar y ejecutar los servicos
 * de un Reporte
 *
 * @author mont
 */
public interface Report {

    /**
     * Realiza una consulta para un reporte
     *
     * @param start Indica la fecha de inicio de consulta de datos la fecha debe
     * de cumplir el formato yyyy-mm-dd
     * @param finish Indica la fecha final de consulta de datos la fecha debe de
     * cumplir el formato <strong>yyyy-mm-dd</strong>
     */
    void realizar(String start, String finish);

    void imprimir();

    void enviar();

    void visualizar();
}
