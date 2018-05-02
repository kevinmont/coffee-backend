package com.coffee.back.dao.impl;

import com.coffee.back.commons.dto.SaleDTO;
import com.coffee.back.dao.AbstractDAO;
import com.coffee.back.dao.SaleProductDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase {@code SaleProductDAOImpl} encargada de implementar
 * {@code SaleProductDAO} la cual establece solicitudes con el servidor de la
 * base de datos de tipo CRUD
 *
 * @see SaleProductDAO
 * @author mont
 */
public class SaleProductDAOImpl extends AbstractDAO implements SaleProductDAO {

    private static final Logger logger = Logger.getLogger(SaleProductDAOImpl.class.getName());

    @Override
    public int create(SaleDTO products) {
        logger.log(Level.INFO, "SaleProductDAO: Inicializando método create()");
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(""
                    + "insert into sale_product(sale_id, product_id, quantity_product, neto)"
                    + "values (?, ?, ?, ?)");
            try (PreparedStatement finalStatement = preparedStatement) {
                logger.log(Level.INFO, "SaleProductDAO: Inicializando recorrido de productos");
                connection.setAutoCommit(false);
                products.getSaleProduct().forEach((t) -> {
                    try {
                        finalStatement.setInt(1, products.getSaleId());
                        finalStatement.setInt(2, t.getProductId());
                        finalStatement.setInt(3, t.getQuantityProduct());
                        finalStatement.setDouble(4, t.getNeto());
                        finalStatement.executeUpdate();
                    } catch (SQLException ex) {
                    }
                });
                connection.commit();
                logger.log(Level.INFO, "SaleProductDAO: Finalizando recorrido de productos despues de commit");
                finalStatement.close();
            }
            preparedStatement.close();
            connection.close();
            logger.log(Level.INFO, "SaleProductDAO: Actualizando filas afectadas de productos");
            rowsAffected = products.getSaleProduct().size();
        } catch (SQLException ex) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                }
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
        logger.log(Level.INFO, "SaleProductDAO: Finalizando método create()");
        return rowsAffected;
    }

}
