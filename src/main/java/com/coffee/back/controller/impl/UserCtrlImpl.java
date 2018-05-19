package com.coffee.back.controller.impl;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.commons.dto.WorkerDTO;
import com.coffee.back.commons.enums.UserType;
import com.coffee.back.commons.exception.NotFoundException;
import com.coffee.back.commons.exception.UserAuthenticationException;
import com.coffee.back.controller.UserCtrl;
import com.coffee.back.controller.parser.UserParser;
import com.coffee.back.controller.parser.WorkerParser;
import com.coffee.back.controller.vo.UserVO;
import com.coffee.back.controller.vo.WorkerVO;
import com.coffee.back.service.UserService;
import com.google.inject.Inject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase {@code UsserCtrlImpl} es encargada de recibir las peticiones
 * lanzadas por el usuario desde la vista, se encarga de manejar y ejecutar los
 * servicos de un Usuario
 *
 * @author mont
 */
public class UserCtrlImpl implements UserCtrl {

    private static final Logger logger = Logger.getLogger(UserCtrlImpl.class.getName());
    private UserService userService;

    @Override
    public UserVO iniciarSesion(UserVO userVO) {
        logger.log(Level.INFO, "CTRL: Método iniciarSesion se ha iniciado");
        // Se convierte el modelo a tipo dto para ser enviado a la capa de DA
        UserDTO userDTO = UserParser.parseToUserDTO(userVO);
        UserVO userVORecover = null;    // Almacenara el usuario recuperado

        try {
            logger.log(Level.INFO, "CTRL: Iniciando sesion");
            // Se recupera el tipo de usuario
            UserDTO userDTORecover = this.userService.iniciarSesion(userDTO);
            // Se convierte el al modelo usuario
            userVORecover = UserParser.parseToUserVO(userDTORecover);
            return userVORecover;
        } catch (UserAuthenticationException ex) {
        }

        logger.log(Level.INFO, "CTRL: Método iniciarSesion ha Finalizado");
        if (userVORecover == null) {
            userVORecover = new UserVO();
            userVORecover.setUserType(UserType.UKNOWN); // El usuario es desconocido
        }
        return userVORecover;
    }

    @Override
    public boolean cerrarSesion(UserVO userVO) {
        logger.log(Level.INFO, "CTRL : Se ha iniciado el método cerrarSesion");
        // Se convierte el modelo usuario al tipo manejado por la capa de DA
        UserDTO userDTO = UserParser.parseToUserDTO(userVO);
        boolean status = this.userService.cerrarSesion(userDTO);
        logger.log(Level.INFO, "CTRL : Finalizando método cerrarSesion");
        return status;
    }

    @Override
    public String bajaUsuario(String nickName) {
        logger.log(Level.INFO, "UserCTRL: se ha iniciado el método bajaUsuario");
        // Se recupera el estado de la operacion
        String status = this.userService.bajaUsuario(nickName);
        logger.log(Level.INFO, "UserCTRL: ha finalizado el método bajaUsuario");
        return status;
    }

    @Override
    public String altaUsuario(WorkerVO workerVO) {
        logger.log(Level.INFO, "UserCTRL#altaUsuario: Iniciando");
        // Se convierte el modelo trabajador al tipo manejado por la capa de DA
        WorkerDTO workerDTO = WorkerParser.parseToWorkerDTO(workerVO);
        // Se recupera el estado de la operacion
        String status = this.userService.altaUsuario(workerDTO);
        logger.log(Level.INFO, "UserCTRL#altaUsuario: Finalizando");
        return status;
    }

    @Override
    public String modificarUsuario(WorkerVO workerVO) {
        logger.log(Level.INFO, "UserCtrl#modificarUsuario Iniciado");
        // Se convierte el modelo trabajador al tipo manejado por la capa de DA
        WorkerDTO workerDTO = WorkerParser.parseToWorkerDTO(workerVO);
        // Se recupera el estado de la operacion
        String status = this.userService.modificarUsuario(workerDTO);
        logger.log(Level.INFO, "UserCtrl#modificarUsuario Finalizando");
        return status;
    }

    @Override // Realizar la busqueda del trabajador con datos propios del usuario
    //pero seria un array de trabajadores
    public WorkerVO buscarUsuario(String name) throws NotFoundException {
        logger.log(Level.INFO, "UserCtrl#buscarUsuario Iniciando...");
        // Se buscar al usuario
        WorkerDTO workerDTO = this.userService.buscarUsuario(name);
        // Se convierte a tipo WorkerVO
        WorkerVO workerVO = WorkerParser.parseToWorkerVO(workerDTO);
        logger.log(Level.INFO, "UserCtrl#modificarUsuario Finalizando...");
        return workerVO;
    }

    @Override
    public List<WorkerVO> buscarUsuarios() {
        logger.log(Level.INFO, "UserCtrl#buscarUsuarios Iniciando...");
        // Se recuperan todos los trabajadores con sus respectivos usuarios
        List<WorkerDTO> workerDTOs=this.userService.recuperarUsuarios();
        // Se convierte el tipo WorkerDTO a tipo WorkerVO
        List<WorkerVO> workerVOs= WorkerParser.parseToWorkerVO(workerDTOs);
        logger.log(Level.INFO, "UserCtrl#buscarUsuarios Finalizado");
        return workerVOs;
    }
    
    @Inject
    /**
     * @param userService El servicio a ser modificado
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
