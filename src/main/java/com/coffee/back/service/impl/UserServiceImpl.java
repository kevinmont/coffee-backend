package com.coffee.back.service.impl;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.commons.enums.UserType;
import com.coffee.back.commons.exception.BadRequest;
import com.coffee.back.commons.exception.UserAunthenticationException;
import com.coffee.back.dao.UserDAO;
import com.coffee.back.dao.WorkerDAO;
import com.coffee.back.dao.entity.User;
import com.coffee.back.service.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mont
 */
public class UserServiceImpl implements UserService {
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
    private UserDAO userDAO;
    private WorkerDAO workerDAO;

    @Override
    public UserDTO iniciarSesion(UserDTO userDTO) throws UserAunthenticationException {
        logger.log(Level.INFO, "Service: Método iniciarSesion se ha iniciado");
        
        if (userDTO == null) {
            throw new IllegalArgumentException("UserDTO is null");
        }
        
        User user= null;
        try {
            user = this.userDAO.getUserByNickName(userDTO.getUserName());
        } catch (BadRequest ex) {
            throw new UserAunthenticationException("Usuario incorrecto, campos incorrectos");
        }
        
        if (userDTO.getPassword().equals(user.getKey())) {
            logger.log(Level.INFO, "Service: Usuario auntenticado, recuperando datos");
            UserType workerRole = this.workerDAO.getRoleNameById(user.getWorkerId());
            logger.log(Level.INFO, "Service: Usuario auntenticado, datos recuperados");
            UserDTO userWorker = new UserDTO();
            userWorker.setUserName(user.getNickName());
            userWorker.setUserType(workerRole);
            return userWorker;
        }
        throw new UserAunthenticationException("El usuario " + user.getNickName() + " es incorrecto");
    }

    @Override
    public void cerrarSesion(UserDTO userDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void altaUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bajaUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
