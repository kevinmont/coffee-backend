package com.coffee.back;

import com.coffee.back.dao.SaleDAO;
import com.coffee.back.dao.impl.SaleDAOImpl;
import com.coffee.back.service.SaleService;
import com.coffee.back.service.impl.SaleServiceImpl;
import com.google.inject.AbstractModule;

/**
 * Clase encargada de configurar las dependencias para el controlador de servicios
 * de tipo Sale.
 * @author mont
 */
public class ConfigureSaleDI extends AbstractModule{

    public ConfigureSaleDI() {
    }

    @Override
    protected void configure() {
        // Se registran las dependencias para el tipo de controlador
        // Sale
        bind(SaleService.class).to(SaleServiceImpl.class);
        bind(SaleDAO.class).to(SaleDAOImpl.class);
    }
    
}
