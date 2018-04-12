package com.coffee.back.controller;

import com.coffee.back.controller.vo.ProductVO;

/**
 * La interfaz {@code ProductCtrl} es encargada de recibir las peticiones lanzadas por el 
 * usuario desde la vista, se encarga de manejar y ejecutar los servicos de un Producto
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
     * @param productName indica el nombre del producto a ser eliminado
     */
    void bajaProducto(String productName);
    
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
     * @param productName Nombre para un producto a ser buscado
     */
    void buscarProducto(String productName);
}
