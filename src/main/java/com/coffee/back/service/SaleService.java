package com.coffee.back.service;

import com.coffee.back.commons.dto.ProductDTO;
import java.util.List;

/**
 * Interface {@code SaleService} encargada de ejecutar la logica de negocio.
 * @author mont
 */
public interface SaleService {
    
    //not implemented yet
    void imprimirTicket();
    
    /**
     * Realiza una venta
     * @param products Indica los productos a ser vendidos
     */
     void realizarVenta(List<ProductDTO> products);
}
