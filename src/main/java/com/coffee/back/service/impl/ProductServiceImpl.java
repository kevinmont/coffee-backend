package com.coffee.back.service.impl;

import com.coffee.back.commons.dto.ProductDTO;
import com.coffee.back.dao.ProductDAO;
import com.coffee.back.service.ProductService;

/**
 *
 * @author mont
 */
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;
    
    @Override
    public boolean altaProducto(ProductDTO productDTO) {
        return this.getProductDAO().insert(productDTO);
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
