package com.coffee.back.controller;

import com.coffee.back.controller.vo.SaleVO;

/**
 * La interfaz {@code SaleCtrl} es encargada de recibir las peticiones lanzadas
 * por el usuario desde la vista, se encarga de manejar y ejecutar los servicos
 * de una Venta
 *
 * @author mont
 */
public interface SaleCtrl {

    /**
     * Finaliza y registra una venta en el sistema
     *
     * @param sale Indica el objeto con los campos de una venta
     * @return {@code Integer} Indica el id de la venta realizada.
     */
    int realizarVenta(SaleVO sale);
}
