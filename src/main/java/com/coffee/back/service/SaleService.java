package com.coffee.back.service;

import com.coffee.back.commons.dto.SaleDTO;

/**
 * Interface {@code SaleService} encargada de ejecutar la logica de negocio.
 *
 * @author mont
 */
public interface SaleService {

    /**
     * Se encargará de imprimir un ticket generado por una venta.
     */
    void imprimirTicket();

    /**
     * Realiza una venta
     *
     * @param sale Indica la venta
     * @return Id de la venta realizada.
     */
    int realizarVenta(SaleDTO sale);

    /**
     * Recupera el id de una venta.
     *
     * @return Id de la venta.
     */
    int getSaleId();
}
