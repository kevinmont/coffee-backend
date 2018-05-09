package com.coffee.back.dao;

import com.coffee.back.commons.dto.CategoryDTO;

/**
 * Interface {@code CategoryDAO} encargada de establecer solicitudes con el
 * servidor de la base de datos de tipo CRUD.
 *
 * @author mont
 */
public interface CategoryDAO {

    /**
     * Recupera el objeto categoria.
     *
     * @param categoryName Nombre de la categoria
     * @return {@code CategoryDTO} Objeto que indica la categoria.
     */
    CategoryDTO getCategoryById(String categoryName);

}
