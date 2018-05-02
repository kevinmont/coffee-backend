package com.coffee.back.service.impl;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.commons.dto.WorkerDTO;
import com.coffee.back.commons.enums.UserType;
import com.coffee.back.commons.exception.BadRequestException;
import com.coffee.back.commons.exception.UserAuthenticationException;
import com.coffee.back.dao.UserDAO;
import com.coffee.back.dao.WorkerDAO;
import com.coffee.back.service.UserService;
import com.google.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase {@code ProductService} encargada de ejecutar la logica de negocio.
 *
 * @author mont
 */
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
    private UserDAO userDAO;
    private WorkerDAO workerDAO;

    @Override
    public UserDTO iniciarSesion(UserDTO userDTO) throws UserAuthenticationException {
        logger.log(Level.INFO, "Service: Método iniciarSesion() se ha iniciado");

        if (userDTO == null) {
            throw new IllegalArgumentException("UserDTO es nullo");
        }

        UserDTO user = null;
        try {
            user = this.userDAO.getUserByNickName(userDTO.getUserName());
        } catch (BadRequestException ex) {
            throw new UserAuthenticationException("Usuario incorrecto, campos incorrectos");
        }

        if (userDTO.getPassword().equals(user.getPassword())) {
            logger.log(Level.INFO, "Service: Usuario autenticado, recuperando datos");
            UserType workerRole = this.workerDAO.getRoleNameByWorkerId(user.getWorkerId());
            logger.log(Level.INFO, "Service: Usuario autenticado, datos recuperados");
            user.setUserType(workerRole);
            return user;
        }
        throw new UserAuthenticationException("El usuario " + user.getUserName() + " es incorrecto");
    }

    @Override
    public boolean cerrarSesion(UserDTO userDTO) {
        logger.log(Level.INFO, "Service#cerrarSesion se ha iniciado");
        if (userDTO.getUserType().equals(UserType.UKNOWN)) {
            try {
                logger.log(Level.INFO, "Service#cerrarSesion Autentificando el usuario");
                UserDTO userLogOut = this.userDAO.getUserByNickName(userDTO.getUserName());
                UserType usertypeLogOut = this.workerDAO.getRoleNameByWorkerId(userLogOut.getWorkerId());
                logger.log(Level.INFO, "Service#cerrarSesion Autentificacion procesada");
                return usertypeLogOut == UserType.ADMINISTRADOR;
            } catch (BadRequestException ex) {
            }
        }
        logger.log(Level.INFO, "Service#cerrarSesion ha finalizado");
        return userDTO.getUserType() == UserType.ADMINISTRADOR;
    }

    @Override
    public String altaUsuario(WorkerDTO workerDTO) {
        logger.log(Level.INFO, "Service#altaUsuario: se ha iniciado");
        if (workerDTO.getWorkerName().isEmpty() || workerDTO.getRoleId() != null) {
            return "Campos incorrectos";
        }
        boolean status = this.workerDAO.create(workerDTO);
        logger.log(Level.INFO, "Service#altaUsuario: ha finalizado");
        return status ? "El usuario " + workerDTO.getWorkerName() + " ha sido creado exitosamente"
                : "Error al intentar crear el usuario " + workerDTO.getWorkerName();
    }

    @Override
    public String bajaUsuario(String nickName) {
        logger.log(Level.INFO, "UserServiceImpl: Iniciando método bajaUsuario()");
        boolean statusOperation;
        try {
            statusOperation = this.userDAO.delete(this.userDAO.getUserByNickName(nickName).getUserName());
        } catch (BadRequestException e) {
            return nickName + " actualmente no existe";
        }

        logger.log(Level.INFO, "UserServiceImpl: Finalizando método bajaUsuario()");
        return statusOperation ? "Usuario " + nickName + " ha sido eliminado exitosamente" : ""
                + "Usuario " + nickName + " actualmente no registrado";
    }

    @Override
    public String modificarUsuario(WorkerDTO workerDTO) {
        logger.log(Level.INFO, "UserServiceImpl#modificarUsuario Iniciando");
        boolean statusWorker = this.workerDAO.update(workerDTO);
        boolean userStatus = this.userDAO.update(workerDTO.getUserDTO());
        boolean status = statusWorker && userStatus;
        logger.log(Level.INFO, "UserServiceImpl#modificarUsuario Iniciando");
        return status ? "Usuario " + workerDTO.getWorkerName() + " ha sido modificado exitosamente"
                : "No se ha podido modificar el usuario " + workerDTO.getWorkerName();
    }

    /**
     * @param userDAO the userDAO to set
     */
    @Inject
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * @param workerDAO the workerDAO to set
     */
    @Inject
    public void setWorkerDAO(WorkerDAO workerDAO) {
        this.workerDAO = workerDAO;
    }

}
