package com.coffee.back.service.impl;

import com.coffee.back.commons.dto.ProductDTO;
import com.coffee.back.dao.ProductDAO;
import com.coffee.back.service.CategoryService;
import com.coffee.back.service.ProductService;
import com.google.inject.Inject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase {@code ProductService} encargada de ejecutar la logica de negocio.
 *
 * @author mont
 */
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = Logger.getLogger(ProductServiceImpl.class.getName());
    private ProductDAO productDAO;
    private CategoryService categoryService;

    @Override
    public String altaProducto(ProductDTO productDTO) {
        logger.log(Level.INFO, "ProductService: Iniciando método altaProducto()");
        boolean status = this.productDAO.create(productDTO);
        logger.log(Level.INFO, "ProductService: Finalizando método altaProducto()");
        return status ? "Creado " + productDTO.getProductName() : "No Creado " + productDTO.getProductName();
    }

    @Override
    public String bajaProducto(String product) {
        logger.log(Level.INFO, "ProductService: Iniciando método bajaProducto()");
        ProductDTO productDTO = this.productDAO.findProductByName(product);
        boolean status = false;
        if (productDTO != null) {
            status = this.productDAO.delete(productDTO.getProductId());
            logger.log(Level.INFO, "ProductService: Fializando método bajaProducto()");
        }
        logger.log(Level.INFO, "ProductService: Finalizando método bajaProducto()");
        return status ? "Eliminado " + product : "No eliminado " + product;
    }

    @Override
    public String actualizarProducto(ProductDTO productDTO) {
        logger.log(Level.INFO, "ProductService: Iniciando método actualizarProducto()");
        productDTO.setCategoryId(this.categoryService.getCategory(productDTO.getProductName()).getCategoryId());
        productDTO.setProductId(this.productDAO.findProductByName(productDTO.getProductName()).getProductId());
        boolean status = this.productDAO.update(productDTO);
        logger.log(Level.INFO, "ProductService: Finalizando método actualizarProducto()");
        return status ? "Actualizado" + productDTO.getProductName() : "No actualizado " + productDTO.getProductName();
    }

    @Override
    public List<ProductDTO> conseguirProductos() {
        logger.log(Level.INFO, "ProductService: Iniciando método conseguirProductos()");
        List<ProductDTO> products = this.productDAO.readAll();
        logger.log(Level.INFO, "ProductService: Finalizando método conseguirProductos()");
        return products;
    }

    @Override
    public List<ProductDTO> buscarProducto(String productName) {
        logger.log(Level.INFO, "ProductService: Iniciando método buscarProducto()");
        List<ProductDTO> products = this.productDAO.findProductsByName(productName);
        logger.log(Level.INFO, "ProductService: Finalizando método buscarProducto()");
        return products;
    }

    @Inject
    /**
     * @param productDAO the productDAO to set
     */
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Inject
    /**
     * @param categoryDAO the categoryService to set
     */
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

}
