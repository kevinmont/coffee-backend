package com.coffee.back.dao.impl;

import com.coffee.back.commons.dto.CategoryDTO;
import com.coffee.back.dao.AbstractDAO;
import com.coffee.back.dao.CategoryDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase {@code CategoryDAOImpl} encargada de implementar {@code CategoryDAO }
 * la cual establece solicitudes con el servidor de la base de datos de tipo
 * CRUD
 *
 * @author mont
 */
public class CategoryDAOImpl extends AbstractDAO implements CategoryDAO {

    private static final Logger logger = Logger.getLogger(CategoryDAOImpl.class.getName());

    @Override
    public CategoryDTO getCategoryByName(String categoryName) {
        logger.log(Level.INFO, "CategoryDAOImpl : Iniciando getCategoryByName()");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CategoryDTO category = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * from category where kind = ?");
            preparedStatement.setString(1, categoryName);
            logger.log(Level.INFO, "CategoryDAOImpl : Ejecutando query");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category = new CategoryDTO();
                category.setCategoryId(resultSet.getInt("category_id"));
                category.setCategoryName(resultSet.getString("kind"));
                logger.log(Level.INFO, "valor de {0}", category.getCategoryId());
            }
            logger.log(Level.INFO, "CategoryDAOImpl : Query finalizado");
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {

        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                }
            }
            closeConnection();
        }
        logger.log(Level.INFO, "CategoryDAOImpl : Finalizando getCategoryByName()");
        return category;
    }

}
