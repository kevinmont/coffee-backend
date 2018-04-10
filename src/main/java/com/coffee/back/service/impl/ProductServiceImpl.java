package com.coffee.back.service.impl;

import com.coffee.back.commons.dto.ProductDTO;
import com.coffee.back.dao.ProductDAO;
import com.coffee.back.service.ProductService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase {@code ProductService} encargada de ejecutar la logica de negocio.
 * @author mont
 */
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = Logger.getLogger(ProductServiceImpl.class.getName());
    private ProductDAO productDAO;
    
    @Override
    public String altaProducto(ProductDTO productDTO) {
        logger.log(Level.INFO, "ProductService: Iniciando método altaProducto()");
        boolean status = this.getProductDAO().create(productDTO);
        logger.log(Level.INFO, "ProductService: Finalizando método altaProducto()");
        return status ? "Creado "+productDTO.getProductName() : "No Creado "+productDTO.getProductName();
    }

    @Override
    public String bajaProducto(ProductDTO productoDTO) {    
        logger.log(Level.INFO, "ProductService: Iniciando método bajaProducto()");
        boolean status = this.productDAO.delete(productoDTO.getProductId());
        logger.log(Level.INFO, "ProductService: Fializando método bajaProducto()");
        return status ? "Eliminado "+ productoDTO.getProductName() : "No eliminado "+productoDTO.getProductName();
    }
    
    @Override
    public String actualizarProducto(ProductDTO productDTO) {
        logger.log(Level.INFO, "ProductService: Iniciando método actualizarProducto()");
        boolean status = this.productDAO.update(productDTO);
        logger.log(Level.INFO, "ProductService: Finalizando método actualizarProducto()");
        return status ? "Actualizado" + productDTO.getProductName() : "No actualizado "+ productDTO.getProductName();
    }
    
    @Override
    public List<ProductDTO> conseguirProductos() {
        logger.log(Level.INFO, "ProductService: Iniciando método conseguirProductos()");
        List<ProductDTO> products = this.productDAO.readAll();
        logger.log(Level.INFO, "ProductService: Finalizando método conseguirProductos()");
        return products;
    }
    
    @Override
    public ProductDTO buscarProducto(Integer productId) {
        logger.log(Level.INFO, "ProductService: Iniciando método buscarProducto()");
        ProductDTO product = this.productDAO.findById(productId);
        logger.log(Level.INFO, "ProductService: Finalizando método buscarProducto()");
        return product;
    }
    /**
     * @return the productDAO
     */
    public ProductDAO getProductDAO() {
        return productDAO;
    }

    /**
     * @param productDAO the productDAO to set
     */
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

}
