package com.coffee.back;

import com.coffee.back.dao.CategoryDAO;
import com.coffee.back.dao.ProductDAO;
import com.coffee.back.dao.impl.CategoryDAOImpl;
import com.coffee.back.dao.impl.ProductDAOImpl;
import com.coffee.back.service.CategoryService;
import com.coffee.back.service.ProductService;
import com.coffee.back.service.impl.CategoryServiceImpl;
import com.coffee.back.service.impl.ProductServiceImpl;
import com.google.inject.AbstractModule;

/**
 * Clase encargada de configurar las dependencias para el controlador de servicios
 * de tipo Producto.
 * @author mont
 */
public class ConfigureProductDI extends AbstractModule{

    public ConfigureProductDI() {
    }
    
    @Override
    protected void configure() {
        // Se registran las dependencias para el tipo de controlador
        // Producto
        bind(ProductService.class).to(ProductServiceImpl.class);
        bind(CategoryService.class).to(CategoryServiceImpl.class);
        bind(ProductDAO.class).to(ProductDAOImpl.class);
        bind(CategoryDAO.class).to(CategoryDAOImpl.class);
    }
    
}
