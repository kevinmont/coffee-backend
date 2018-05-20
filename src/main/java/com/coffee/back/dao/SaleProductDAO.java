package com.coffee.back.dao;

import com.coffee.back.commons.dto.SaleDTO;
import java.sql.SQLException;
import java.util.List;

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
    int create(SaleDTO products) throws SQLException;

    /**
     * Recupera los productos vendidos para cada venta.
     *
     * @param saleID Representa el id de la venta.
     * @return {@code List<SaleProduct>} Los productos pertenecientes a la
     * venta.
     */
    public List<SaleDTO.SaleProduct> getProductsSoldByThisSale(Integer saleID);
}
