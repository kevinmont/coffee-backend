package com.coffee.back.service.impl;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.commons.enums.UserType;
import com.coffee.back.commons.exception.BadRequestException;
import com.coffee.back.commons.exception.UserAuthenticationException;
import com.coffee.back.dao.UserDAO;
import com.coffee.back.dao.WorkerDAO;
import com.coffee.back.dao.entity.User;
import com.coffee.back.service.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase {@code ProductService} encargada de ejecutar la logica de negocio.
 * @author mont
 */
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
    private UserDAO userDAO;
    private WorkerDAO workerDAO;

    @Override
    public UserDTO iniciarSesion(UserDTO userDTO) throws UserAuthenticationException {
        logger.log(Level.INFO, "Service: Método iniciarSesion se ha iniciado");

        if (userDTO == null) {
            throw new IllegalArgumentException("UserDTO es nullo");
        }

        User user = null;
        try {
            user = this.getUserDAO().getUserByNickName(userDTO.getUserName());
        } catch (BadRequestException ex) {
            throw new UserAuthenticationException("Usuario incorrecto, campos incorrectos");
        }

        if (userDTO.getPassword().equals(user.getKey())) {
            logger.log(Level.INFO, "Service: Usuario auntenticado, recuperando datos");
            UserType workerRole = this.getWorkerDAO().getRoleNameByWorkerId(user.getWorkerId());
            logger.log(Level.INFO, "Service: Usuario auntenticado, datos recuperados");
            UserDTO userWorker = new UserDTO();
            userWorker.setUserName(user.getNickName());
            userWorker.setUserType(workerRole);
            return userWorker;
        }
        throw new UserAuthenticationException("El usuario " + user.getNickName() + " es incorrecto");
    }

    @Override
    public boolean cerrarSesion(UserDTO userDTO) {
        if (userDTO.getUserType().equals(UserType.UKNOWN)) {
            try {
                User userLogOut = this.userDAO.getUserByNickName(userDTO.getUserName());
                UserType usertypeLogOut = this.workerDAO.getRoleNameByWorkerId(userLogOut.getWorkerId());
                return usertypeLogOut == UserType.ADMINISTRADOR;
            } catch (BadRequestException ex) {
            }
        }
        return userDTO.getUserType() == UserType.ADMINISTRADOR;
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

    /**
     * @return the userDAO
     */
    public UserDAO getUserDAO() {
        return userDAO;
    }

    /**
     * @param userDAO the userDAO to set
     */
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * @return the workerDAO
     */
    public WorkerDAO getWorkerDAO() {
        return workerDAO;
    }

    /**
     * @param workerDAO the workerDAO to set
     */
    public void setWorkerDAO(WorkerDAO workerDAO) {
        this.workerDAO = workerDAO;
    }

}
