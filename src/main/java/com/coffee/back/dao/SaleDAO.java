package com.coffee.back.dao;

import com.coffee.back.commons.dto.SaleDTO;
import java.sql.Date;
import java.util.List;

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
     * @return {@code Integer} El numero de producto vendidos.
     */
    int createAndUpdateCatalog(SaleDTO saleDTO);

    /**
     * Recupera ventas en el periodo indicado
     *
     * @param since Fecha inicial de la venta
     * @param until Fecha final de la ventas
     * @return
     */
    List<SaleDTO> getSales(Date since, Date until);

    /**
     * Recupera el id de la ultima venta.
     *
     * @return Integer Indica el id de la ultima venta realizada.
     */
    Integer getLastSale();
}
