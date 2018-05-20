package com.coffee.back.dao.impl;

import com.coffee.back.commons.dto.SaleDTO;
import com.coffee.back.dao.AbstractDAO;
import com.coffee.back.dao.SaleDAO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    public int createAndUpdateCatalog(SaleDTO saleDTO) {
        logger.log(Level.INFO, "SaleDAOImpl: Inicializando método create() para venta");
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement("INSERT INTO "
                    + " sale(worker_id, sale_id, date_sale, amount)"
                    + " values (?, ?, ? ,?)");
            preparedStatement.setInt(1, saleDTO.getCashierId());
            preparedStatement.setInt(2, saleDTO.getSaleId());
            preparedStatement.setDate(3, saleDTO.getDateSale());
            preparedStatement.setDouble(4, saleDTO.getTotalSale());
            int saleAffected = preparedStatement.executeUpdate();
            connection.commit();
            logger.log(Level.INFO, "SaleDAOImpl: Actualización finalizado");
            SaleProductDAOImpl saleProductDAOImpl = new SaleProductDAOImpl();
            try {
                rowsAffected = saleProductDAOImpl.create(saleDTO); // Se actualizan los productos vendidos.
            } catch (SQLException ex) {
                if (saleAffected != 0) {
                    PreparedStatement preparedStatement1Error = connection.prepareStatement("DELETE FROM sale where"
                            + " sale_id= ? and worker_id= ?");
                    preparedStatement1Error.setInt(1, saleDTO.getSaleId());
                    preparedStatement1Error.setInt(2, saleDTO.getCashierId());
                    logger.log(Level.SEVERE, "Resolviendo conflictos con venta registrada");
                    try {
                        int a = preparedStatement1Error.executeUpdate();
                        connection.commit();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                logger.log(Level.SEVERE, "No se pudo realizar acabo la venta");
            }
            logger.log(Level.INFO, "SaleDAOImpl: Fin Actualización venta de productos");
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
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
        logger.log(Level.INFO, "SaleDAOImpl: Finalizando método create() para venta");
        return rowsAffected;
    }

    @Override
    public List<SaleDTO> getSales(Date since, Date until) {
        logger.log(Level.INFO, "SaleDAOImpl: Método getSales() se ha iniciado");
        PreparedStatement preparedStatement = null;
        ResultSet saleSet = null;
        List<SaleDTO> saleDTOs = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM sale WHERE date_sale between"
                    + " ? and ? ");
            preparedStatement.setDate(1, since);
            preparedStatement.setDate(2, until);

            saleSet = preparedStatement.executeQuery();
            logger.log(Level.INFO, "SaleDAOImpl: Query ejecutado");
            saleDTOs = new ArrayList<>();
            while (saleSet.next()) {
                SaleDTO saleTemp = new SaleDTO();
                saleTemp.setDateSale(saleSet.getDate("date_sale"));
                saleTemp.setSaleId(saleSet.getInt("sale_id"));
                saleTemp.setCashierId(saleSet.getInt("worker_id"));
                saleTemp.setTotalSale(saleSet.getDouble("amount"));
                saleDTOs.add(saleTemp);
            }
            logger.log(Level.INFO, "SaleDAOImpl: Sales completo");

            saleSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
        } finally {
            if (saleSet != null) {
                try {
                    saleSet.close();
                } catch (SQLException ex) {
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                }
            }
            closeConnection();
        }
        logger.log(Level.INFO, "SaleDAOImpl: Método getSales() Finalizado");
        return saleDTOs;
    }

    @Override
    public Integer getLastSale() {
        logger.log(Level.INFO, "SaleDAOImpl: Método getSales() se ha iniciado");
        PreparedStatement preparedStatement = null;
        ResultSet saleSet = null;
        Integer saleMaxId = 0;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT max(sale_id) as maxsale FROM sale");

            saleSet = preparedStatement.executeQuery();
            logger.log(Level.INFO, "SaleDAOImpl: Query ejecutado");

            if (saleSet.next()) {
                saleMaxId = saleSet.getInt("maxsale");
            }
            logger.log(Level.INFO, "SaleDAOImpl: Sale completo");

            saleSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
        } finally {
            if (saleSet != null) {
                try {
                    saleSet.close();
                } catch (SQLException ex) {
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                }
            }
            closeConnection();
        }
        logger.log(Level.INFO, "SaleDAOImpl: Método getSales() Finalizado");
        return saleMaxId;
    }

}
