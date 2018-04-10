package com.coffee.back.service.impl;

import com.coffee.back.commons.dto.ProductDTO;
import com.coffee.back.dao.SaleDAO;
import com.coffee.back.service.SaleService;
import java.util.List;

/**
 * Clase {@code ProductService} encargada de ejecutar la logica de negocio.
 * @author mont
 */
public class SaleServiceImpl implements SaleService {

    private SaleDAO saleDAO;

    @Override
    public void imprimirTicket() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void realizarVenta(List<ProductDTO> products){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
