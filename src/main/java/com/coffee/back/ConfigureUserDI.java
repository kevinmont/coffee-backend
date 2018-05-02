package com.coffee.back;

import com.coffee.back.dao.UserDAO;
import com.coffee.back.dao.WorkerDAO;
import com.coffee.back.dao.impl.UserDAOImpl;
import com.coffee.back.dao.impl.WorkerDAOImpl;
import com.coffee.back.service.UserService;
import com.coffee.back.service.impl.UserServiceImpl;
import com.google.inject.AbstractModule;

/**
 * Clase encargada de configurar las dependencias para el controlador de servicios
 * de tipo User.
 * @author mont
 */
public class ConfigureUserDI extends AbstractModule{

    public ConfigureUserDI() {
    }

    @Override
    protected void configure() {
        // Se registran las dependencias para el tipo de controlador
        // User
        bind(UserService.class).to(UserServiceImpl.class);
        bind(UserDAO.class).to(UserDAOImpl.class);
        bind(WorkerDAO.class).to(WorkerDAOImpl.class);
    }
}
