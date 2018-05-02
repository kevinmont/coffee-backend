package com.coffee.back.controller;

import com.coffee.back.controller.vo.ProductVO;
import java.util.List;

/**
 * La interfaz {@code ProductCtrl} es encargada de recibir las peticiones
 * lanzadas por el usuario desde la vista, se encarga de manejar y ejecutar los
 * servicos de un Producto
 *
 * @author mont
 */
public interface ProductCtrl {

    /**
     * Ingresa un nuevo producto al sistema
     *
     * @param productVO indica el producto a dar de alta
     * @return {@code String} El estado de la operación
     */
    String altaProducto(ProductVO productVO);

    /**
     * Elimina un producto existe en el sistema
     *
     * @param productName indica el nombre del producto a ser eliminado
     * @return {@code String} El estado de la operacion
     */
    String bajaProducto(String productName);

    /**
     * Actualiza un producto existente en el sistema
     *
     * @param productVO Identifica a un producto a ser editado
     * @return {@code String} El estado de la operación
     */
    String modificarProducto(ProductVO productVO);

    /**
     * Recupera todos los productos registrado en el sistema
     *
     * @return {@code List<ProductVO>} Todos los productos registrados en el
     * sistema.
     */
    List<ProductVO> conseguirProductos();

    /**
     * Recupera un producto en especifico registrado en el sistema
     *
     * @param productName Nombre del producto
     * @return {@code List<ProductVO>} Contiene los productos que coinciden con
     * el parametro {@code productName} recuperado
     */
    List<ProductVO> buscarProducto(String productName);
}
