package com.coffee.back.service;

import com.coffee.back.commons.dto.SaleDTO;
import java.sql.Date;
import java.util.List;

/**
 * Interface {@code ReportService} encargada de ejecutar la logica de negocio.
 *
 * @author mont
 */
public interface ReportService {

    /**
     * Recupera las ventas que se efectuaron en el periodo indicado.
     *
     * @param since Indica el comienzo de la fecha para la recuperacion de
     * ventas que se efectuaron en ese periodo
     * @param until Indica el final de la fecha para la recuperacion de ventas
     * que se efectuaron en ese periodo
     * @return {@code List<SaleDTO>} Ventas que se efectuaron durante el periodo
     * indicado
     */
    List<SaleDTO> recoverSales(Date since, Date until);
}
