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
 *
 * @author mont
 */
public class ConfigureProductDI extends AbstractModule{

    public ConfigureProductDI() {
    }

    @Override
    protected void configure() {
        bind(ProductService.class).to(ProductServiceImpl.class);
        bind(CategoryService.class).to(CategoryServiceImpl.class);
        bind(ProductDAO.class).to(ProductDAOImpl.class);
        bind(CategoryDAO.class).to(CategoryDAOImpl.class);
    }
    
}
