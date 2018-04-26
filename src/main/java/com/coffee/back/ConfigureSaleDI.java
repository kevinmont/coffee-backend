package com.coffee.back;

import com.coffee.back.dao.SaleDAO;
import com.coffee.back.dao.impl.SaleDAOImpl;
import com.coffee.back.service.SaleService;
import com.coffee.back.service.impl.SaleServiceImpl;
import com.google.inject.AbstractModule;

/**
 *
 * @author mont
 */
public class ConfigureSaleDI extends AbstractModule{

    public ConfigureSaleDI() {
    }

    @Override
    protected void configure() {
        bind(SaleService.class).to(SaleServiceImpl.class);
        bind(SaleDAO.class).to(SaleDAOImpl.class);
    }
    
}
