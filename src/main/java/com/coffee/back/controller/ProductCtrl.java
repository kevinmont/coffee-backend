package com.coffee.back.controller;

import com.coffee.back.controller.vo.ProductVO;

/**
 *
 * @author mont
 */
public interface ProductCtrl {
    
    /**
     * Ingresa un nuevo producto al sistema
     * @param productVO indica el producto a dar de alta
     */
    void altaProducto(ProductVO productVO);
    
    /**
     * Eliminar un producto existe dentro sistema
     * @param productVO indica el producto a ser eliminado
     */
    void bajaProducto(ProductVO productVO);
    
    void actualizarProducto(ProductVO productVO);
}
