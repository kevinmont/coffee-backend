package com.coffee.back.service.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.commons.enums.UserType;
import com.coffee.back.commons.exception.BadRequest;
import com.coffee.back.commons.exception.UserAunthenticationException;
import com.coffee.back.dao.UserDAO;
import com.coffee.back.dao.WorkerDAO;
import com.coffee.back.service.UserService;

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
            throw new IllegalArgumentException("UserDTO es nullo");
        }

        UserDTO user = null;
        try {
            user = this.getUserDAO().getUserByNickName(userDTO.getUserName());
        } catch (BadRequest ex) {
            throw new UserAunthenticationException("Usuario incorrecto, campos incorrectos");
        }

        if (userDTO.getPassword().equals(user.getPassword())) {
            logger.log(Level.INFO, "Service: Usuario auntenticado, recuperando datos");
            UserType workerRole = this.workerDAO.getRoleNameByWorkerId(user.getWorkerId());
            logger.log(Level.INFO, "Service: Usuario auntenticado, datos recuperados");
            user.setUserType(workerRole);
            return user;
        }
        throw new UserAunthenticationException("El usuario " + user.getUserName() + " es incorrecto");
    }

    @Override
    public boolean cerrarSesion(UserDTO userDTO) {
        if (userDTO.getUserType().equals(UserType.UKNOWN)) {
            try {
                UserDTO userLogOut = this.userDAO.getUserByNickName(userDTO.getUserName());
                UserType usertypeLogOut = this.workerDAO.getRoleNameByWorkerId(userLogOut.getWorkerId());
                return usertypeLogOut == UserType.ADMINISTRADOR;
            } catch (BadRequest ex) {
            }
        }
        return userDTO.getUserType() == UserType.ADMINISTRADOR;
    }

    @Override
    public String altaUsuario(UserDTO userDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String bajaUsuario(String nickName) {
        logger.log(Level.INFO, "UserServiceImpl: Iniciando método bajaUsuario()");
    	boolean statusOperation = false;
        try {
        	 statusOperation = this.userDAO.delete(this.userDAO.getUserByNickName(nickName).getUserName());
		} catch (BadRequest e) {
			return nickName +" actualmente no existe";
		}
        
        logger.log(Level.INFO, "UserServiceImpl: Finalizando método bajaUsuario()");
        return statusOperation ? "Usuario "+nickName +" ha sido eliminado exitosamente" :""
        		+ "Usuario "+ nickName+ " actualmente no registrado";
    }

    @Override
    public String modificarUsuario(UserDTO userDTO) {
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
