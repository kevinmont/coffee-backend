package com.coffee.back.dao.impl;

import com.coffee.back.commons.dto.ProductDTO;
import com.coffee.back.dao.AbstractDAO;
import com.coffee.back.dao.ProductDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mont
 */
public class ProductDAOImpl extends AbstractDAO implements ProductDAO {

    private static final Logger LOGGER = Logger.getLogger(ProductDAOImpl.class.getName());
    
    @Override
    public boolean create(ProductDTO productDTO) {
        LOGGER.log(Level.INFO, "ProductDAO: Inicializado Insert");
        
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("insert into product "
                    + "(product_id, product_name, price_tag, quantity, is_food, image, category_id) "
                    + "values (?, ?, ?, ? ,? ,? ,?)");
            preparedStatement.setInt(1, productDTO.getProductId());
            preparedStatement.setString(2, productDTO.getProductName());
            preparedStatement.setDouble(3, productDTO.getPriceTag());
            preparedStatement.setShort(4, productDTO.getQuantity());
            preparedStatement.setBoolean(5, productDTO.getIsFood());
            preparedStatement.setString(6, productDTO.getImage());
            preparedStatement.setInt(7, productDTO.getCategoryId());
            
            LOGGER.log(Level.INFO, "ProductDAO: Finalizado Insert");
            return preparedStatement.executeUpdate() > 1;
        } catch (SQLException ex) {
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    //Omitido excepción
                }
            }
            closeConnection();
        }
        LOGGER.log(Level.INFO, "ProductDAO: Finalizado Insert, estado: false");
        return false;
    }

    @Override
    public List<ProductDTO> readAll() {
        LOGGER.log(Level.INFO, "ProductDAO: Inicializando método readAll()");
        PreparedStatement preparedStatement = null; 
        ResultSet result = null;
        List<ProductDTO> productDTOs = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select * from product");
            result = preparedStatement.executeQuery();
            
            productDTOs = new ArrayList<>();
            while(result.next()){
                ProductDTO temp = new ProductDTO();
                temp.setProductId(result.getInt("product_id"));
                temp.setProductName(result.getString("product_name"));
                temp.setPriceTag(result.getDouble("price_tag"));
                temp.setQuantity(result.getShort("quantity"));
                temp.setIsFood(result.getBoolean("is_food"));
                temp.setImage(result.getString("image"));
                temp.setCategoryId(result.getInt("category_id"));
                
                productDTOs.add(temp);
            }
        } catch (SQLException ex) {
            
        }finally {
            if(preparedStatement != null && result != null){
                try {
                    result.close();
                    preparedStatement.close();
                } catch (SQLException ex) {                    
                }
            }
            closeConnection();
        }
        LOGGER.log(Level.INFO, "ProductDAO: Finalizando método readAll()");        
        return productDTOs;
    }

    @Override
    public boolean update(ProductDTO productDTO) {
        LOGGER.log(Level.INFO, "ProductDAO: inicializando método update()");
        boolean rowsAffected = false;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("UPDATE product SET"
                    + " product_id = ?, product_name = ?,"
                    + " price_tag = ?, quantity = ?, is_food = ?,"
                    + " image = ?, category_id = ?"
                    + " WHERE product_id = "+ productDTO.getProductId());
            
            preparedStatement.setInt(1, productDTO.getProductId());
            preparedStatement.setString(2, productDTO.getProductName());
            preparedStatement.setDouble(3, productDTO.getPriceTag());
            preparedStatement.setShort(4, productDTO.getQuantity());
            preparedStatement.setBoolean(5, productDTO.getIsFood());
            preparedStatement.setString(6, productDTO.getImage());
            preparedStatement.setInt(7, productDTO.getCategoryId());
            
            rowsAffected = preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            
        }finally{
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                }
            }
            closeConnection();
        }
        LOGGER.log(Level.INFO, "ProductDAO: Finalizando método update()");
        return rowsAffected;
    }

    @Override
    public boolean delete(Integer productId) {
        LOGGER.log(Level.INFO, "ProductDAO: inicializando método delete()");
        boolean rowsAffected = false;
        PreparedStatement preparedStatement = null;
        
        try {    
            connection = getConnection();
            preparedStatement = connection.prepareStatement(""
                    + "DELETE FROM product where product_id = ?");
            preparedStatement.setInt(1, productId);
            rowsAffected = preparedStatement.executeUpdate()> 0;
            
        } catch (SQLException ex) {
            
        }finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                }
            }
            closeConnection();
        }
        LOGGER.log(Level.INFO, "ProductDAO: finalizando método delete()");
        return rowsAffected;
    }

    @Override
    public ProductDTO findById(Integer productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
