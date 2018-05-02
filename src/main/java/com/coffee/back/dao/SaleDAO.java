package com.coffee.back.dao;

import com.coffee.back.commons.dto.SaleDTO;

/**
 * Interface {@code SaleDAO} encargada de establecer solicitudes con el servidor
 * de la base de datos de tipo CRUD
 *
 * @author mont
 */
public interface SaleDAO {

    /**
     * Inserta productos nuevos en el sistema.
     *
     * @param saleDTO Indica la venta
     * @return {@code Integer} Numero de productos dados de alta
     */
    int create(SaleDTO saleDTO);
}
