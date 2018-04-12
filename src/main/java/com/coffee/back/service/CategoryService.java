package com.coffee.back.service;

import com.coffee.back.commons.dto.CategoryDTO;

/**
 * Interface {@code CategoryService} encargada de ejecutar la logica de negocio.
 * @author mont
 */
public interface CategoryService {

    /**
     * Recupera una Categoria en especifica
     * @param Name Nombre de categoria
     * @return {@code CategoryDTO} Una categoria
     */
    CategoryDTO getCategory(String Name);
    
}
