package com.coffee.back.dao.impl;

import com.coffee.back.commons.dto.SaleDTO;
import com.coffee.back.commons.dto.SaleDTO.SaleProduct;
import com.coffee.back.dao.AbstractDAO;
import com.coffee.back.dao.SaleProductDAO;
import com.coffee.back.service.ProductService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    public int create(SaleDTO products) throws SQLException {
        logger.log(Level.INFO, "SaleProductDAO: Inicializando método create() para productos");
        logger.log(Level.INFO, "SaleProductDAO: Insertando lista de productos");
        
        Iterator<SaleDTO.SaleProduct> iterator = products.getSaleProduct().iterator();
        int rowsAffected = 0;
        connection = getConnection();
        connection.setAutoCommit(false);
        while (iterator.hasNext()) {
            try {
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO sale_product (sale_id, product_id, quantity_product, neto)"
                        + " VALUES (?, ?, ?, ?)")) {
                    SaleProduct producto = iterator.next();
                    preparedStatement.setInt(1, products.getSaleId());
                    preparedStatement.setInt(2, producto.getProductId());
                    preparedStatement.setInt(3, producto.getQuantityProduct());
                    preparedStatement.setDouble(4, producto.getNeto());
                    preparedStatement.executeUpdate();
                    rowsAffected++;
                }
            } catch (SQLException ex) {
                if (connection != null) {
                    connection.rollback();
                }
                throw ex; // se lanza la excepcion y se cancela
            }
        }
        connection.commit();
        logger.log(Level.INFO, "SaleProductDAO: Insercion finalizado");
        logger.log(Level.INFO, "SaleProductDAO: Finalizando método create() para productos");
        return rowsAffected;
    }
    
    @Override
    public List<SaleDTO.SaleProduct> getProductsSoldByThisSale(Integer saleID
    ) {
        logger.log(Level.INFO, "SaleProductDAOImpl: Método getSales() se ha iniciado");
        PreparedStatement preparedStatement = null;
        ResultSet saleProductSet = null;
        List<SaleDTO.SaleProduct> saleProducts = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM"
                    + " sale_product WHERE sale_id = ?");
            preparedStatement.setInt(1, saleID);
            
            saleProductSet = preparedStatement.executeQuery();
            logger.log(Level.INFO, "SaleProductDAOImpl: Query ejecutado");
            saleProducts = new ArrayList<>();
            while (saleProductSet.next()) {
                SaleDTO das = new SaleDTO();
                SaleDTO.SaleProduct saleProductsTemp = das.new SaleProduct();
                saleProductsTemp.setProductId(saleProductSet.getInt("product_id"));
                saleProductsTemp.setQuantityProduct(saleProductSet.getInt("quantity_product"));
                saleProducts.add(saleProductsTemp);
            }
            
            logger.log(Level.INFO, "SaleProductDAOImpl: Sales completo");
            saleProductSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
        } finally {
            if (saleProductSet != null) {
                try {
                    saleProductSet.close();
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
        return saleProducts;
    }
    
}
