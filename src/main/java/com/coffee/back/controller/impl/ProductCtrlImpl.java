package com.coffee.back.controller.impl;

import com.coffee.back.commons.dto.ProductDTO;
import com.coffee.back.controller.ProductCtrl;
import com.coffee.back.controller.parser.ProductParser;
import com.coffee.back.controller.vo.ProductVO;
import com.coffee.back.service.ProductService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mont
 */
public class ProductCtrlImpl implements ProductCtrl {

    private static final Logger logger = Logger.getLogger(ProductCtrlImpl.class.getName());
    private ProductService productService;

    @Override
    public void altaProducto(ProductVO productVO) {
        logger.log(Level.INFO, "ProductCTRL: Iniciando método altaProducto");

        ProductDTO newProduct = ProductParser.parseToProductDTO(productVO);
        String statusOperation = this.productService.altaProducto(newProduct); // Contiene el estatus de la operacion
        // Desplegar en vista mensaje

        logger.log(Level.INFO, "ProductCTRL: Finalizado método altaProducto");
    }

    @Override
    public void bajaProducto(ProductVO productVO) {
        logger.log(Level.INFO, "ProductCTRL: Iniciado método bajaProducto");
        
        ProductDTO newProduct = ProductParser.parseToProductDTO(productVO);
        String statusOperation = this.productService.bajaProducto(newProduct);
        // Deslplegar en vista estatus
        
        logger.log(Level.INFO, "ProductCTRL: Finalizado método bajaProducto");
        
    }

}
