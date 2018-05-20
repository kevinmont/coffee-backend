package com.coffee.back;

import com.coffee.back.dao.ProductDAO;
import com.coffee.back.dao.SaleDAO;
import com.coffee.back.dao.SaleProductDAO;
import com.coffee.back.dao.UserDAO;
import com.coffee.back.dao.impl.ProductDAOImpl;
import com.coffee.back.dao.impl.SaleDAOImpl;
import com.coffee.back.dao.impl.SaleProductDAOImpl;
import com.coffee.back.dao.impl.UserDAOImpl;
import com.coffee.back.service.ReportService;
import com.coffee.back.service.impl.ReportServiceImpl;
import com.google.inject.AbstractModule;

/**
 * Clase encargada de configurar las dependencias para el controlador de
 * servicios de tipo Report.
 *
 * @author mont
 */
public class ConfigureReportDI extends AbstractModule {
    
    public ConfigureReportDI() {
        
    }
    
    @Override
    protected void configure() {
        // Se registran las dependencias para el tipo de controlador
        // Producto
        bind(ReportService.class).to(ReportServiceImpl.class);
        bind(SaleDAO.class).to(SaleDAOImpl.class);
        bind(SaleProductDAO.class).to(SaleProductDAOImpl.class);
        bind(UserDAO.class).to(UserDAOImpl.class);
        bind(ProductDAO.class).to(ProductDAOImpl.class);
        
    }
    
}
