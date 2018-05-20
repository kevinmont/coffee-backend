package com.coffee.back.controller;

import com.coffee.back.controller.vo.SaleVO;
import java.util.List;

/**
 * La interfaz {@code ReportCtrl} es encargada de recibir las peticiones
 * lanzadas por el usuario desde la vista, se encarga de manejar y ejecutar los
 * servicos de un Reporte
 *
 * @author mont
 */
public interface ReportCtrl {

    /**
     * Realiza una consulta para un reporte
     *
     * @param start Indica la fecha de inicio de consulta de datos la fecha debe
     * de cumplir el formato <strong>yyyy-mm-dd</strong>
     * @param finish Indica la fecha final de consulta de datos la fecha debe de
     * cumplir el formato <strong>yyyy-mm-dd</strong>
     * @return {@code List<SaleVO>} Ventas que se realizaron durante el periodo
     * si no existe vents durante el periodo, la lista estará vacia
     */
    List<SaleVO> recuperarVentas(String start, String finish);

    void imprimir();

    void enviar();

    void visualizar();
}
