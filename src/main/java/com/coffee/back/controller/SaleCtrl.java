package com.coffee.back.controller;

import com.coffee.back.commons.dto.SaleDTO;

/**
 * La interfaz {@code SaleCtrl} es encargada de recibir las peticiones lanzadas por el 
 * usuario desde la vista, se encarga de manejar y ejecutar los servicos de una Venta
 * @author mont
 */
public interface SaleCtrl {
    /**
     * Finaliza una venta y da de alta en el sistema
     * @param sale Indica el objeto con los campos de una venta
     */
    void realizarVenta(SaleDTO sale);
}
