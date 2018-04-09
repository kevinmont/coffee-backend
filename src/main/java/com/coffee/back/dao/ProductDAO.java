package com.coffee.back.dao;

import com.coffee.back.commons.dto.ProductDTO;
import java.util.List;

/**
 *
 * @author mont
 */
public interface ProductDAO {
    
    /**Crea un nuevo producto
     * @param productDTO
     * @return {@code true} si el producto se ha dado de alta exitosamente
     * de lo contrario {@code false}
     */
    boolean create(ProductDTO productDTO);
    
    /**
     * Recupera los productos dados de alta en el sistema
     * @return {@code List<ProductDTO>} contiene todos los productos existentes en el sistema
     */
    List<ProductDTO> readAll();
    
    boolean update(ProductDTO productDTO);
    
    /**
     * Elimina un producto
     * @param productId indica el {@code ID} unico, del producto a eliminar
     * @return {@code true} si el producto se ha eliminado exitosamente
     * de lo contrario  {@code false}
     */
    boolean delete(Integer productId);
    
    /**
     * Busca un producto unico
     * @param productId identificador del producto a ser buscado
     * @return {@code ProductDTO} que se encuentra registrado en el sistema
     */
    ProductDTO findById(Integer productId);
    
}
