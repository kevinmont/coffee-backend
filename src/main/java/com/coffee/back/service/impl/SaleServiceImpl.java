package com.coffee.back.service.impl;

import com.coffee.back.commons.dto.SaleDTO;
import com.coffee.back.commons.exception.BadRequestException;
import com.coffee.back.dao.SaleDAO;
import com.coffee.back.dao.UserDAO;
import com.coffee.back.service.SaleService;
import com.google.inject.Inject;
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
    private UserDAO userDao;

    @Override
    public int realizarVenta(SaleDTO sale) {
        logger.log(Level.INFO, "SaleServiceImpl: Inicializando método realizarVenta()");
        if (sale != null) {

            if (sale.getCashierId() == null && !sale.getCashierNickName().isEmpty()) {
                try {
                    sale.setCashierId(this.userDao.getUserByNickName(sale.getCashierNickName()).getWorkerId());
                } catch (BadRequestException ex) {
                    logger.log(Level.WARNING, "No existe un cajero para asignarle a esta venta");
                }
            }
            int rowsAffected = this.saleDAO.createAndUpdateCatalog(sale);
            logger.log(Level.INFO, "Se han actualizado {0} productos", rowsAffected);
            logger.log(Level.WARNING, "El catalogo de productos es actualizado mediante un trigger");
        }
        logger.log(Level.INFO, "SaleServiceImpl: Finalizando método realizarVenta()");
        return sale.getSaleId();
    }

    @Override
    public void imprimirTicket() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Inject
    /**
     * @param saleDAO dependencia de una venta a ser modificada
     */
    public void setSaleDAO(SaleDAO saleDAO) {
        this.saleDAO = saleDAO;
    }

    @Inject
    public void setUserDAO(UserDAO userDao) {
        this.userDao = userDao;
    }
}
