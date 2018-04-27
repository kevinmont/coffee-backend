package com.coffee.back.service;

import com.coffee.back.commons.dto.SaleDTO;

/**
 * Interface {@code SaleService} encargada de ejecutar la logica de negocio.
 * @author mont
 */
public interface SaleService {
    
    /**
     * Se encargará de imprimir un ticket generado por una venta.
     */
    void imprimirTicket();
    
    /**
     * Realiza una venta
     * @param sale Indica la venta
     * @return Indica el numero de articulos vendidos
     */
     int realizarVenta(SaleDTO sale);
}
