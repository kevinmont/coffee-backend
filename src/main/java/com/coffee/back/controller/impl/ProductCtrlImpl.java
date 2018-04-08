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
public class ProductCtrlImpl implements ProductCtrl{
    
    private static final Logger LOGGER = Logger.getLogger(ProductCtrlImpl.class.getName());
    private ProductService productService;
    
    @Override
    public void altaProducto(ProductVO productVO) {
        LOGGER.log(Level.INFO,"ProductCTRL: Iniciado altaProducto");
        
        ProductDTO newProduct= ProductParser.parseToProductDTO(productVO);
        boolean stateTransaction = this.productService.altaProducto(newProduct);
        
        if(stateTransaction){
            // Alta producto sin errores
        }else{
            // Alta producto con errores
        }
        
        LOGGER.log(Level.INFO,"ProductCTRL: Finalizado altaProducto");
    }
    
}
