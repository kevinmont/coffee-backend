package com.coffee.back.dao.impl;

import com.coffee.back.commons.dto.ProductDTO;
import com.coffee.back.dao.AbstractDAO;
import com.coffee.back.dao.ProductDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mont
 */
public class ProductDAOImpl extends AbstractDAO implements ProductDAO {

    @Override
    public boolean insert(ProductDTO productDTO) {
        PreparedStatement preparedStament = null;
        try {
            connection = getConnection();
            preparedStament = connection.prepareStatement("insert into product "
                    + "(product_id, product_name, price_tag, quantity, is_food, image, category_id) "
                    + "values (?, ?, ?, ? ,? ,? ,?)");
            preparedStament.setInt(1, productDTO.getProductId());
            preparedStament.setString(2, productDTO.getProductName());
            preparedStament.setDouble(3, productDTO.getPriceTag());
            preparedStament.setShort(4, productDTO.getQuantity());
            preparedStament.setBoolean(5, productDTO.getIsFood());
            preparedStament.setString(6, productDTO.getImage());
            preparedStament.setInt(7, productDTO.getCategoryId());
            return preparedStament.executeUpdate() > 1;

        } catch (SQLException ex) {
        } finally {
            if (preparedStament != null) {
                try {
                    preparedStament.close();
                } catch (SQLException ex) {
                    //Omitido excepción
                }
            }
            closeConnection();
        }
        return false;
    }

}
