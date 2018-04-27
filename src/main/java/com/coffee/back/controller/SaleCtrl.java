package com.coffee.back.controller;

import com.coffee.back.controller.vo.SaleVO;

/**
 * La interfaz {@code SaleCtrl} es encargada de recibir las peticiones lanzadas por el 
 * usuario desde la vista, se encarga de manejar y ejecutar los servicos de una Venta
 * @author mont
 */
public interface SaleCtrl {
    /**
     * Finaliza una venta y da de alta en el sistema
     * @param sale Indica el objeto con los campos de una venta
     * @return {@code Integer} indicando el numero de productos vendidos
     */
    int realizarVenta(SaleVO sale);
}
