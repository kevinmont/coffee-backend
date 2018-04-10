package com.coffee.back.dao;

import com.coffee.back.commons.dto.SaleDTO;
import com.coffee.back.commons.exception.TransactionException;
import java.util.List;

/**
 * Interface {@code SaleDAO} encargada de establecer solicitudes con el servidor
 * de la base de datos de tipo CRUD
 * @author mont
 */
public interface SaleDAO {
    
    /**
     * Creación de los productos en el sistema
     * @param products productos a ser creados en el sistema
     * @return {@code Integer} Numero de productos dados de alta
     * @throws com.coffee.back.commons.exception.TransactionException Si la operación ha fallado 
     */
    int create(List<SaleDTO> products) throws TransactionException;
}
