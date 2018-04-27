package com.coffee.back.controller.impl;

import com.coffee.back.commons.dto.ProductDTO;
import com.coffee.back.controller.ProductCtrl;
import com.coffee.back.controller.parser.ProductParser;
import com.coffee.back.controller.vo.ProductVO;
import com.coffee.back.service.CategoryService;
import com.coffee.back.service.ProductService;
import com.google.inject.Inject;
import java.util.ArrayList;
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
    public String altaProducto(ProductVO productVO) {
        logger.log(Level.INFO, "ProductCTRL: Iniciando método altaProducto");
        ProductDTO newProduct = ProductParser.parseToProductDTO(productVO);
        newProduct.setCategoryId(this.categoryService.getCategory(productVO.getCategoryName()).getCategoryId());
        String statusOperation = this.productService.altaProducto(newProduct); // Contiene el estatus de la operacion
        logger.log(Level.INFO, "ProductCTRL: Finalizado método altaProducto");
        return statusOperation;
    }

    @Override
    public String bajaProducto(String productName) {
        logger.log(Level.INFO, "ProductCTRL: Iniciado método bajaProducto");
        String statusOperation = this.productService.bajaProducto(productName);
        logger.log(Level.INFO, "ProductCTRL: Finalizado método bajaProducto");
        return statusOperation;
    }

     @Override
    public String modificarProducto(ProductVO productVO) {
        logger.log(Level.INFO, "ProductCtrl: Iniciando método actualizarProducto()");
        ProductDTO productDTO = ProductParser.parseToProductDTO(productVO);
        String statusOperation = this.productService.actualizarProducto(productDTO);
        logger.log(Level.INFO, "ProductCtrl: Finalizando método actualizarProducto()");
        return statusOperation; 
    }
    
    @Override
    public List<ProductVO> conseguirProductos(){
        logger.log(Level.INFO, "ProductCtrl: Iniciando método conseguirProducto()");
        List<ProductDTO> allProducuts = this.productService.conseguirProductos();
        List<ProductVO> productVOs =ProductParser.parseToProductDTO(allProducuts);
        logger.log(Level.INFO, "ProductCtrl: Finalizando método conseguirProducto()");
        return productVOs;
    }
    
    @Override
    public ProductVO buscarProducto(String productName){
        logger.log(Level.INFO, "ProductCtrl: Iniciando método buscarProducto()");
        ProductDTO producDTO= this.productService.buscarProducto(productName);
        ProductVO productRetrieved = ProductParser.parseToProductVO(producDTO);
        logger.log(Level.INFO, "ProductCtrl: Finalizando método buscarProducto()");
        return productRetrieved;
    }
    
    @Inject
    /**
     * @param productService El servicio a ser modificado
     */
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Inject
    /**
     * @param categoryService the categoryService to set
     */
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

}
