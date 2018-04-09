package com.coffee.back.service.impl;

import com.coffee.back.commons.dto.ProductDTO;
import com.coffee.back.dao.ProductDAO;
import com.coffee.back.service.ProductService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mont
 */
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = Logger.getLogger(ProductServiceImpl.class.getName());
    private ProductDAO productDAO;
    
    @Override
    public String altaProducto(ProductDTO productDTO) {
        logger.log(Level.INFO, "ProductService: Iniciando método altaProducto()");
        boolean status = this.getProductDAO().create(productDTO);
        logger.log(Level.INFO, "ProductService: Finalizando método altaProducto()");
        return status ? "Creado "+productDTO.getProductName() : "No Creado "+productDTO.getProductName();
    }

    @Override
    public String bajaProducto(ProductDTO productoDTO) {    
        logger.log(Level.INFO, "ProductService: Iniciando método bajaProducto()");
        boolean status = this.productDAO.delete(productoDTO.getProductId());
        logger.log(Level.INFO, "ProductService: Fializando método bajaProducto()");
        return status ? "Eliminado "+ productoDTO.getProductName() : productoDTO.getProductName();
    }
    
    /**
     * @return the productDAO
     */
    public ProductDAO getProductDAO() {
        return productDAO;
    }

    /**
     * @param productDAO the productDAO to set
     */
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

}
