package com.coffee.back.dao;

import com.coffee.back.commons.dto.SaleDTO;

/**
 * Interfaz {@code SaleProductDAO} encargada de establecer solicitudes con el
 * servidor de la base de datos de tipo CRUD
 *
 * @author mont
 */
public interface SaleProductDAO {

    /**
     * Creación de los productos en el sistema
     *
     * @param products productos a ser creado en el sistema
     * @return {@code Integer} Numero de productos dados de alta
     */
    int create(SaleDTO products);
}
