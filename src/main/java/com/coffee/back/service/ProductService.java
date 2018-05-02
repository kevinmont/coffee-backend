package com.coffee.back.service;

import com.coffee.back.commons.dto.ProductDTO;
import java.util.List;

/**
 * Interface {@code ProductService} encargada de ejecutar la logica de negocio.
 *
 * @author mont
 */
public interface ProductService {

    /**
     * Ingresa un nuevo producto al sistema
     *
     * @param productDTO indica el nuevo producto ha ser dado de alta en el
     * sistema
     * @return {@code String} en el formato Nombre del producto concatenado con
     * el estatus de la operación
     */
    String altaProducto(ProductDTO productDTO);

    /**
     * Elimina un producto existente en el sistema
     *
     * @param product indica el producto ha ser eliminado
     * @return {@code String} en el formato Nombre del producto concatenado con
     * el estatus de la operación
     */
    String bajaProducto(String product);

    /**
     * Actualiza un producto existente en el sistema
     *
     * @param productDTO indica el objeto con las actualizaciones
     * @return {@code String} en el formato Nombre del producto concatenado con
     * el estatus de la operación
     */
    String actualizarProducto(ProductDTO productDTO);

    /**
     * Recupera todos los productos registrados en el sistema
     *
     * @return {@code List<ProductDTO>} contiene todos los productos registrador
     * en el sistema
     */
    List<ProductDTO> conseguirProductos();

    /**
     * Busca un producto registrado en el sistema
     *
     * @param productName Nombre del producto a ser buscado
     * @return {@code List<ProductDTO>} productos registrados en el sistema
     */
    List<ProductDTO> buscarProducto(String productName);

}
