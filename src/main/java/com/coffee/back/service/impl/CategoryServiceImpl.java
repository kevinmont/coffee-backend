package com.coffee.back.service.impl;

import com.coffee.back.commons.dto.CategoryDTO;
import com.coffee.back.dao.CategoryDAO;
import com.coffee.back.service.CategoryService;
import com.google.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase {@code CategoryServiceImpl} encargada de implementar
 * {@code ProductService} y de ejecutar la logica de negocio.
 *
 * @author mont
 * @since 09/04/2018 Objetivo, o problema que resuelve el programa Fecha de
 * creación y fecha de modificación
 */
public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = Logger.getLogger(CategoryServiceImpl.class.getName());
    private CategoryDAO categoryDAO;

    @Override
    public CategoryDTO getCategory(String Name) {
        logger.log(Level.INFO, "CategoryServiceImpl: Iniciando método getCategoryIdByName");
        CategoryDTO category = this.categoryDAO.getCategoryByName(Name);
        if (category == null) {
            try {
                throw new Exception("No existe category con dicho nombre");
            } catch (Exception ex) {

            }
        }
        logger.log(Level.INFO, "CategoryServiceImpl: Finalizando método getCategoryIdByName");
        return category;
    }

    @Inject
    /**
     * @param categoryDAO Una categoriaDAO el acceso a dato a ser modificada
     */
    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

}
