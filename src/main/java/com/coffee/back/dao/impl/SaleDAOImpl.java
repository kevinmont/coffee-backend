package com.coffee.back.dao.impl;

import com.coffee.back.commons.dto.SaleDTO;
import com.coffee.back.dao.AbstractDAO;
import com.coffee.back.dao.SaleDAO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase {@code SaleDAOImpl} encargada de implementar {@code SaleDAO }
 * la cual establece solicitudes con el servidor de la base de datos de tipo
 * CRUD
 *
 * @see SaleDAO
 * @author mont
 */
public class SaleDAOImpl extends AbstractDAO implements SaleDAO {

    private static final Logger logger = Logger.getLogger(SaleDAOImpl.class.getName());

    @Override
    public int create(SaleDTO saleDTO) {
        logger.log(Level.INFO, "SaleDAOImpl: Inicializando método create()");
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("insert into "
                    + "sale(worker_id, sale_id, date_sale, amount)"
                    + "values (?, ?, ? ,?)");

            preparedStatement.setInt(1, saleDTO.getWorkerId());
            preparedStatement.setInt(2, saleDTO.getSaleId());
            preparedStatement.setDate(3, (Date) saleDTO.getDateSale());
            preparedStatement.setDouble(4, saleDTO.getAmount());
            logger.log(Level.INFO, "SaleDAOImpl: Actualizando venta");
            preparedStatement.executeUpdate();
            connection.commit();
            logger.log(Level.INFO, "SaleDAOImpl: Actualización finalizado");
            logger.log(Level.INFO, "SaleDAOImpl: Inicio Actualización venta de productos");
            SaleProductDAOImpl saleProductDAOImpl = new SaleProductDAOImpl();
            saleProductDAOImpl.create(saleDTO);
            logger.log(Level.INFO, "SaleDAOImpl: Fin Actualización venta de productos");
            preparedStatement.close();
            connection.close();
            rowsAffected = saleDTO.getSaleProduct().size();
        } catch (SQLException ex) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex1) {
            }
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                }
            }
            closeConnection();
        }
        logger.log(Level.INFO, "SaleDAOImpl: Finalizando método create()");
        return rowsAffected;
    }

}
