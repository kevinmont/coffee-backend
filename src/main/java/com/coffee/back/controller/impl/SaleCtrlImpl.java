package com.coffee.back.controller.impl;

import com.coffee.back.commons.dto.SaleDTO;
import com.coffee.back.controller.SaleCtrl;
import com.coffee.back.controller.parser.SaleParser;
import com.coffee.back.controller.vo.SaleVO;
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
    public void realizarVenta(SaleVO sale) {
        logger.log(Level.INFO, "SaleCTRL: Inicializando método realizarVenta()");
        SaleDTO saleDTO = SaleParser.parseToUserDTO(sale);
        int totalOfProductsSold =this.getSaleService().realizarVenta(saleDTO);
        // Mostrar mensaje de productos vendidos si es necesario
        logger.log(Level.INFO, "SaleCTRL: Finalizando método realizarVenta()");
    }

    /**
     * @return {@code SaleService} dependencia de servicio
     */
    public SaleService getSaleService() {
        return saleService;
    }

    /**
     * @param saleService dependencia del servicio a modificar
     */
    public void setSaleService(SaleService saleService) {
        this.saleService = saleService;
    }
    
}
