package com.coffee.back.dao;

import com.coffee.back.commons.dto.ProductDTO;
import java.util.List;

/**
 * Interface {@code ProductDAO} encargada de establecer solicitudes con el
 * servidor de la base de datos de tipo CRUD.
 *
 * @author mont
 */
public interface ProductDAO {

    /**
     * Crea un nuevo producto
     *
     * @param productDTO
     * @return {@code true} si el producto se ha dado de alta exitosamente de lo
     * contrario {@code false}
     */
    boolean create(ProductDTO productDTO);

    /**
     * Recupera los productos dados de alta en el sistema
     *
     * @return {@code List<ProductDTO>} contiene todos los productos existentes
     * en el sistema
     */
    List<ProductDTO> readAll();

    /**
     * Actualiza un producto.
     *
     * @param productDTO producto actualizado.
     * @return {@code true} si se actualizo exitosamente de lo contrario se
     * {@code false}.
     */
    boolean update(ProductDTO productDTO);

    /**
     * Elimina un producto
     *
     * @param productId indica el {@code ID} unico, del producto a eliminar
     * @return {@code true} si el producto se ha eliminado exitosamente de lo
     * contrario {@code false}
     */
    boolean delete(Integer productId);

    /**
     * Busca productos
     *
     * @param productName identificador del producto a ser buscado
     * @return {@code ProductDTO} que se encuentra registrado en el sistema
     */
    List<ProductDTO> findProductsByName(String productName);

    /**
     * Busca un producto.
     *
     * @param productName Indica el nombre del producto.
     * @return {@code ProductDTO} producto recuperado.
     */
    ProductDTO findProductByName(String productName);

}
