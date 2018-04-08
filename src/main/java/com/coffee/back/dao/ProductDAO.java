package com.coffee.back.dao;

import com.coffee.back.commons.dto.ProductDTO;

/**
 *
 * @author mont
 */
public interface ProductDAO {
    
    boolean insert(ProductDTO productDTO);
}
