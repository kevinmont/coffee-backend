package com.coffee.back.dao.impl;

import com.coffee.back.commons.dto.CategoryDTO;
import com.coffee.back.dao.AbstractDAO;
import com.coffee.back.dao.CategoryDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mont
 */
public class CategoryDAOImpl extends AbstractDAO implements CategoryDAO {

    @Override
    public CategoryDTO getCategoryByName(String categoryName) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CategoryDTO category = null;
        try{
            connection = getConnection();
            preparedStatement = connection.prepareStatement(""
                    + "select * from category where kind = ?");
            preparedStatement.setString(1, categoryName);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                category = new CategoryDTO();
                category.setCategoryId(resultSet.getInt("category_id"));
                category.setCategoryName(resultSet.getString("kind"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch(SQLException ex){
            
        } finally {
            if(resultSet != null)
                try {
                    resultSet.close();
            } catch (SQLException ex) {
            }
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                }
            }
            closeConnection();
        }
        return category;
    }
    
}
