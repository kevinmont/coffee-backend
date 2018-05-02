package com.coffee.back.controller.impl;

import com.coffee.back.commons.dto.SaleDTO;
import com.coffee.back.controller.SaleCtrl;
import com.coffee.back.controller.parser.SaleParser;
import com.coffee.back.controller.vo.SaleVO;
import com.coffee.back.service.SaleService;
import com.google.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase {@code SaleCtrlImpl} es encargada de recibir las peticiones lanzadas
 * por el usuario desde la vista, se encarga de manejar y ejecutar los servicos
 * de una Venta
 *
 * @author mont
 */
public class SaleCtrlImpl implements SaleCtrl {

    private static final Logger logger = Logger.getLogger(SaleCtrlImpl.class.getName());
    private SaleService saleService;

    @Override
    public int realizarVenta(SaleVO sale) {
        logger.log(Level.INFO, "SaleCTRL: Inicializando método realizarVenta()");
        // Se convierte el modelo al tipo de objeto de transporte a la capa DA
        SaleDTO saleDTO = SaleParser.parseToUserDTO(sale);
        // Se recupera el numero de productos vendidos
        int totalOfProductsSold = this.saleService.realizarVenta(saleDTO);
        logger.log(Level.INFO, "SaleCTRL: Finalizando método realizarVenta()");
        return totalOfProductsSold;
    }

    @Inject
    /**
     * @param saleService El servicio de sale a ser configurado
     */
    public void setSaleService(SaleService saleService) {
        this.saleService = saleService;
    }

}
