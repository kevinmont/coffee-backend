package com.coffee.back.service;

import com.coffee.back.commons.dto.SaleDTO;

/**
 * Interface {@code SaleService} encargada de ejecutar la logica de negocio.
 * @author mont
 */
public interface SaleService {
    
    //not implemented yet
    void imprimirTicket();
    
    /**
     * Realiza una venta
     * @param sale Indica la venta
     */
     int realizarVenta(SaleDTO sale);
}
