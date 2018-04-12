package com.coffee.back.controller.impl;

import com.coffee.back.commons.dto.ProductDTO;
import com.coffee.back.controller.ProductCtrl;
import com.coffee.back.controller.parser.ProductParser;
import com.coffee.back.controller.vo.ProductVO;
import com.coffee.back.service.CategoryService;
import com.coffee.back.service.ProductService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase {@code ProductCtrlImpl} es encargada de recibir las peticiones lanzadas por el 
 * usuario desde la vista, se encarga de manejar y ejecutar los servicos de un Producto
 * @author mont
 */
public class ProductCtrlImpl implements ProductCtrl {

    private static final Logger logger = Logger.getLogger(ProductCtrlImpl.class.getName());
    private ProductService productService; // Dependencia de los servicios
    private CategoryService categoryService;
    
    @Override
    public void altaProducto(ProductVO productVO) {
        logger.log(Level.INFO, "ProductCTRL: Iniciando método altaProducto");

        ProductDTO newProduct = ProductParser.parseToProductDTO(productVO);
        newProduct.setCategoryId(this.categoryService.getCategory(productVO.getCategoryName()).getCategoryId());
        String statusOperation = this.productService.altaProducto(newProduct); // Contiene el estatus de la operacion
        // Desplegar en vista mensaje
        
        logger.log(Level.INFO, "ProductCTRL: Finalizado método altaProducto");
    }

    @Override
    public void bajaProducto(String productName) {
        logger.log(Level.INFO, "ProductCTRL: Iniciado método bajaProducto");
        
        String statusOperation = this.productService.bajaProducto(productName);
        // Desplegar en vista estatus
        
        logger.log(Level.INFO, "ProductCTRL: Finalizado método bajaProducto");
        
    }

     @Override
    public void modificarProducto(ProductVO productVO) {
        logger.log(Level.INFO, "ProductCtrl: Iniciando método actualizarProducto()");
        
        ProductDTO productDTO = ProductParser.parseToProductDTO(productVO);
        String statusOperation = this.productService.actualizarProducto(productDTO);
        // Desplegar en vista estatus de la operación
       
        logger.log(Level.INFO, "ProductCtrl: Finalizando método actualizarProducto()");
    }
    
    @Override
    public void conseguirProductos(){
        logger.log(Level.INFO, "ProductCtrl: Iniciando método conseguirProducto()");
        List<ProductDTO> products = this.productService.conseguirProductos();
        // Se debe de desplegar los productos en vista
        logger.log(Level.INFO, "ProductCtrl: Finalizando método conseguirProducto()");
    }
    
    @Override
    public void buscarProducto(String productName){
        logger.log(Level.INFO, "ProductCtrl: Iniciando método buscarProducto()");
        ProductDTO producto= this.productService.buscarProducto(productName);
        // Se debe de desplegar el producto a vista
        logger.log(Level.INFO, "ProductCtrl: Finalizando método buscarProducto()");
    }
    
    /**
     * @return {@code ProductService} dependecia del servicio
     */
    public ProductService getProductService() {
        return productService;
    }

    /**
     * @param productService El servicio a ser modificado
     */
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * @return the categoryService
     */
    public CategoryService getCategoryService() {
        return categoryService;
    }

    /**
     * @param categoryService the categoryService to set
     */
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

}
