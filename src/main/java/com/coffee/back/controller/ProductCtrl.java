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
    
    /**
     * Actualiza un producto existente en el sistema
     * @param productVO Identifica a un producto a ser editado
     */
    void modificarProducto(ProductVO productVO);
    
    /**
     * Recupera todos los productos registrado en el sistema
     */
    void conseguirProductos();
    
    /**
     * Recupera un producto en especifico registrado en el sistema
     * @param productId Identificador unico para un producto a ser buscado
     */
    void buscarProducto(Integer productId);
}
