package com.coffee.back.service.impl;

import com.coffee.back.commons.dto.SaleDTO;
import com.coffee.back.dao.SaleDAO;
import com.coffee.back.service.SaleService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase {@code ProductService} encargada de ejecutar la logica de negocio.
 *
 * @author mont
 */
public class SaleServiceImpl implements SaleService {

    private static final Logger logger = Logger.getLogger(SaleServiceImpl.class.getName());
    private SaleDAO saleDAO;

    @Override
    public void imprimirTicket() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int realizarVenta(SaleDTO sale) {
        logger.log(Level.INFO, "SaleServiceImpl: Inicializando método realizarVenta()");
        int totalProductsAffected = 0;
        if (sale != null) {
            totalProductsAffected = this.saleDAO.create(sale);
        }
        logger.log(Level.INFO, "SaleServiceImpl: Finalizando método realizarVenta()");
        return totalProductsAffected;
    }

    /**
     * @param saleDAO dependencia de una venta a ser modificada
	*
     */
    public void setSaleDAO(SaleDAO saleDAO) {
        this.saleDAO = saleDAO;
    }
}
