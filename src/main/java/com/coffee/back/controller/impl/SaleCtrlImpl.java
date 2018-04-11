package com.coffee.back.controller.impl;

import com.coffee.back.commons.dto.SaleDTO;
import com.coffee.back.controller.SaleCtrl;
import com.coffee.back.service.SaleService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase {@code SaleCtrlImpl} es encargada de recibir las peticiones lanzadas por el 
 * usuario desde la vista, se encarga de manejar y ejecutar los servicos de una Venta
 * @author mont
 */
public class SaleCtrlImpl implements SaleCtrl{

    private static final Logger logger = Logger.getLogger(SaleCtrlImpl.class.getName());
    private SaleService saleService;
    @Override
    public void realizarVenta(SaleDTO sale) {
        logger.log(Level.INFO, "SaleCTRL: Inicializando método realizarVenta()");
        int totalOfProductsSold =this.saleService.realizarVenta(sale);
        // Mostrar mensaje de productos vendidos si es necesario
        logger.log(Level.INFO, "SaleCTRL: Finalizando método realizarVenta()");
    }
    
}
