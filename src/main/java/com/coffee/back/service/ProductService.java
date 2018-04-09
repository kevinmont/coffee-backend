package com.coffee.back.service;

import com.coffee.back.commons.dto.ProductDTO;

/**
 *
 * @author mont
 */
public interface ProductService {
    
    /**
     * Ingresa un nuevo producto al sistema
     * @param productDTO indica el nuevo producto ha ser dado de alta en el sistema
     * @return {@code String} en el formato Nombre del producto concatenado con el estatus
     * de la operación
     */
    String altaProducto(ProductDTO productDTO);
    
    /**
     * Elimina un producto existente en el sistema
     * @param productoDTO indica el producto ha ser eliminado
     * @return {@code String} en el formato Nombre del producto concatenado con el estatus
     * de la operación
     */
    String bajaProducto(ProductDTO productoDTO);
    
    /**
     * Actualiza un producto existente en el sistema
     * @param productDTO indica el objeto con las actualizaciones
     * @return {@code String} en el formato Nombre del producto concatenado con el estatus
     * de la operación
     */
    String actualizarProducto(ProductDTO productDTO);
    
}
