package com.coffee.back;

import com.coffee.back.dao.UserDAO;
import com.coffee.back.dao.WorkerDAO;
import com.coffee.back.dao.impl.UserDAOImpl;
import com.coffee.back.dao.impl.WorkerDAOImpl;
import com.coffee.back.service.UserService;
import com.coffee.back.service.impl.UserServiceImpl;
import com.google.inject.AbstractModule;

/**
 *
 * @author mont
 */
public class ConfigureUserDI extends AbstractModule{

    public ConfigureUserDI() {
    }

    @Override
    protected void configure() {
        bind(UserService.class).to(UserServiceImpl.class);
        bind(UserDAO.class).to(UserDAOImpl.class);
        bind(WorkerDAO.class).to(WorkerDAOImpl.class);
    }
}
