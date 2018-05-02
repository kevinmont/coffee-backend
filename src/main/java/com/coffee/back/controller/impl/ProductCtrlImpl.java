package com.coffee.back.controller.impl;

import com.coffee.back.commons.dto.ProductDTO;
import com.coffee.back.controller.ProductCtrl;
import com.coffee.back.controller.parser.ProductParser;
import com.coffee.back.controller.vo.ProductVO;
import com.coffee.back.service.CategoryService;
import com.coffee.back.service.ProductService;
import com.google.inject.Inject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase {@code ProductCtrlImpl} es encargada de recibir las peticiones
 * lanzadas por el usuario desde la vista, se encarga de manejar y ejecutar los
 * servicos de un Producto
 *
 * @author mont
 */
public class ProductCtrlImpl implements ProductCtrl {

    private static final Logger logger = Logger.getLogger(ProductCtrlImpl.class.getName());
    private ProductService productService;  // Dependencia de servicio hacia Producto
    private CategoryService categoryService;// Dependencia de servicio hacia Categoria

    @Override
    public String altaProducto(ProductVO productVO) {
        logger.log(Level.INFO, "ProductCTRL: Iniciando método altaProducto");
        // Se convierte el modelo categoria al tipo manejado por la capa de DA
        ProductDTO newProduct = ProductParser.parseToProductDTO(productVO);
        // Se recupera la categoria al que pertenece el producto
        newProduct.setCategoryId(this.categoryService.getCategory(productVO.getCategoryName()).getCategoryId());
        // Se guarda el estado de la operacion al ejecutar alta producto
        String statusOperation = this.productService.altaProducto(newProduct); 
        logger.log(Level.INFO, "ProductCTRL: Finalizado método altaProducto");
        return statusOperation;
    }

    @Override
    public String bajaProducto(String productName) {
        logger.log(Level.INFO, "ProductCTRL: Iniciado método bajaProducto");
        // Se guarda el estado de la operacion al ejecutar baja producto
        String statusOperation = this.productService.bajaProducto(productName);
        logger.log(Level.INFO, "ProductCTRL: Finalizado método bajaProducto");
        return statusOperation;
    }

    @Override
    public String modificarProducto(ProductVO productVO) {
        logger.log(Level.INFO, "ProductCtrl: Iniciando método actualizarProducto()");
        // Se convierte el modelo producto al tipo manejado por la capa de DA
        ProductDTO productDTO = ProductParser.parseToProductDTO(productVO);
        // Se guarda el estado de la operacion al ejecutar actualizar producto
        String statusOperation = this.productService.actualizarProducto(productDTO);
        logger.log(Level.INFO, "ProductCtrl: Finalizando método actualizarProducto()");
        return statusOperation;
    }

    @Override
    public List<ProductVO> conseguirProductos() {
        logger.log(Level.INFO, "ProductCtrl: Iniciando método conseguirProducto()");
        // Se recuperan los productos existentes
        List<ProductDTO> allProducuts = this.productService.conseguirProductos();
        // Se convierten los productos al modelo correspondiente manejados por la vista
        List<ProductVO> productVOs = ProductParser.parseToProductDTO(allProducuts);
        logger.log(Level.INFO, "ProductCtrl: Finalizando método conseguirProducto()");
        return productVOs;
    }

    @Override
    public List<ProductVO> buscarProducto(String productName) {
        logger.log(Level.INFO, "ProductCtrl: Iniciando método buscarProducto()");
        // Se recuperan los productos que coinciden con el nombre del producto
        List<ProductDTO> producsDTO = this.productService.buscarProducto(productName);
        // Se convierten los productos al modelo correspondiente manejados por la vista
        List<ProductVO> productsVO = ProductParser.parseToProductVO(producsDTO);
        logger.log(Level.INFO, "ProductCtrl: Finalizando método buscarProducto()");
        return productsVO;
    }

    @Inject
    /**
     * @param productService El servicio de producto a ser configurado
     */
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Inject
    /**
     * @param categoryService El servicio de categoria a ser configurado
     */
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

}
