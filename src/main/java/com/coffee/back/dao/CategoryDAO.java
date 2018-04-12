package com.coffee.back.dao;

import com.coffee.back.commons.dto.CategoryDTO;

/**
 *
 * @author mont
 */
public interface CategoryDAO {
    
    CategoryDTO getCategoryByName(String categoryName);
    
}
