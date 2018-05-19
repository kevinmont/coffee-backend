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
 * Clase {@code ProductDAOImp} encargada de implementar {@code ProductDAO }
 * la cual establece solicitudes con el servidor de la base de datos de tipo
 * CRUD
 *
 * @see ProductDAO
 * @author mont
 */
public class ProductDAOImpl extends AbstractDAO implements ProductDAO {

    private static final Logger LOGGER = Logger.getLogger(ProductDAOImpl.class.getName());

    @Override
    public boolean create(ProductDTO productDTO) {
        LOGGER.log(Level.INFO, "ProductDAO: Inicializado Insert");

        PreparedStatement preparedStatement = null;
        boolean rowsAffected = false;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("insert into product"
                    + " (product_name, price_tag, quantity, image, category_id)"
                    + " values (?, ? ,? ,? ,?)");
            preparedStatement.setString(1, productDTO.getProductName());
            preparedStatement.setDouble(2, productDTO.getPriceTag());
            preparedStatement.setShort(3, productDTO.getQuantity());
            preparedStatement.setString(4, productDTO.getImage());
            preparedStatement.setInt(5, productDTO.getCategoryId());
            rowsAffected = preparedStatement.executeUpdate() > 0;
            LOGGER.log(Level.INFO, "ProductDAO: Finalizado Insert");
            preparedStatement.close();
            connection.close();
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
        return rowsAffected;
    }

    @Override
    public List<ProductDTO> readAll() {
        LOGGER.log(Level.INFO, "ProductDAO: Inicializando método readAll()");
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        List<ProductDTO> productDTOs = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select * from product"
                    + " join category using(category_id)");
            result = preparedStatement.executeQuery();

            productDTOs = new ArrayList<>();
            while (result.next()) {
                ProductDTO temp = new ProductDTO();
                temp.setProductId(result.getInt("product_id"));
                temp.setProductName(result.getString("product_name"));
                temp.setPriceTag(result.getDouble("price_tag"));
                temp.setQuantity(result.getShort("quantity"));
                temp.setImage(result.getString("image"));
                temp.setCategoryId(result.getInt("category_id"));
                temp.setCategoryName(result.getString("kind"));
                productDTOs.add(temp);
            }
            result.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {

        } finally {
            if (result != null) {
                try {
                    result.close();
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
                    + " product_name= ?,"
                    + " price_tag = ?, quantity = ?,"
                    + " image = ?, category_id = ?"
                    + " WHERE product_id = ?");
            LOGGER.log(Level.INFO,"Producto id a editar {0}",productDTO.getProductId());
            preparedStatement.setString(1, productDTO.getProductName());
            LOGGER.log(Level.INFO,"Producto id a editar {0}",productDTO.getPriceTag());
            preparedStatement.setDouble(2, productDTO.getPriceTag());
            preparedStatement.setShort(3, productDTO.getQuantity());
            preparedStatement.setString(4, productDTO.getImage());
            preparedStatement.setInt(5, productDTO.getCategoryId());
            preparedStatement.setInt(6, productDTO.getProductId());
            
            rowsAffected = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (preparedStatement != null) {
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
            preparedStatement = connection.prepareStatement("DELETE FROM "
                    + "product where product_id = ?");
            preparedStatement.setInt(1, productId);
            rowsAffected = preparedStatement.executeUpdate() > 0;
            LOGGER.log(Level.INFO,"Product where id has been deleted {0}", productId);
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (preparedStatement != null) {
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
    public List<ProductDTO> findProductsByName(String productName) {
        LOGGER.log(Level.INFO, "ProductDAO#findProductsByName Iniciando método ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<ProductDTO> products = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM product join "
                    + " category using(category_id) where product_name "
                    + " LIKE ?");
            preparedStatement.setString(1, "%" + productName + "%");
            resultSet = preparedStatement.executeQuery();
            LOGGER.log(Level.INFO, "ProductDAO#findProductsByName consulta ejecutada");
            products = new ArrayList<>();
            while (resultSet.next()) {
                ProductDTO temp = new ProductDTO();
                temp.setProductId(resultSet.getInt("product_id"));
                temp.setProductName(resultSet.getString("product_name"));
                temp.setPriceTag(resultSet.getDouble("price_tag"));
                temp.setQuantity(resultSet.getShort("quantity"));
                temp.setImage(resultSet.getString("image"));
                temp.setCategoryId(resultSet.getInt("category_id"));
                temp.setCategoryName(resultSet.getString("kind"));
                products.add(temp);
            }
            LOGGER.log(Level.INFO, "ProductDAO: Llenado completo ProductDTO");
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                }
            }
            closeConnection();
        }
        LOGGER.log(Level.INFO, "ProductDAO#findProductsByName finalizando");
        return products;
    }

    @Override
    public ProductDTO findProductByName(String productName) {
        LOGGER.log(Level.INFO, "ProductDAO#findProductByName: Iniciando método ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ProductDTO product = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM product"
                    + " join category using(category_id) where"
                    + " product_name = ?");
            preparedStatement.setString(1, productName);
            resultSet = preparedStatement.executeQuery();
            LOGGER.log(Level.INFO, "ProductDAO: Llenando Objeto ProductDTO");
            if (resultSet.next()) {
                product = new ProductDTO();
                product.setProductId(resultSet.getInt("product_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setPriceTag(resultSet.getDouble("price_tag"));
                product.setQuantity(resultSet.getShort("quantity"));
                product.setImage(resultSet.getString("image"));
                product.setCategoryId(resultSet.getInt("category_id"));
                product.setCategoryName(resultSet.getString("kind"));
                LOGGER.log(Level.INFO, "ProductDAO: Llenado completo ProductDTO");
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                }
            }
            closeConnection();
        }
        LOGGER.log(Level.INFO, "ProductDAO: Finalizando método findProductByName()");
        return product;
    }
    
    @Override
    public ProductDTO findProductById(Integer productId) {
        LOGGER.log(Level.INFO, "ProductDAO#findProductById: Iniciando método ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ProductDTO product = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM product"
                    + " join category using(category_id) where"
                    + " product_id = ?");
            preparedStatement.setInt(1, productId);
            resultSet = preparedStatement.executeQuery();
            product = new ProductDTO();
            LOGGER.log(Level.INFO, "ProductDAO: Llenando Objeto ProductDTO");
            if (resultSet.next()) {
                product.setProductId(resultSet.getInt("product_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setPriceTag(resultSet.getDouble("price_tag"));
                product.setQuantity(resultSet.getShort("quantity"));
                product.setImage(resultSet.getString("image"));
                product.setCategoryId(resultSet.getInt("category_id"));
                product.setCategoryName(resultSet.getString("kind"));
            }
            LOGGER.log(Level.INFO, "ProductDAO: Llenado completo ProductDTO");
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                }
            }
            closeConnection();
        }
        LOGGER.log(Level.INFO, "ProductDAO: Finalizando método findProductById()");
        return product;
    }

}
