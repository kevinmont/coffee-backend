package com.coffee.back.controller.impl;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.commons.enums.UserType;
import com.coffee.back.commons.exception.UserAuthenticationException;
import com.coffee.back.controller.UserCtrl;
import com.coffee.back.controller.parser.UserParser;
import com.coffee.back.controller.vo.UserVO;
import com.coffee.back.service.UserService;
import com.google.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase {@code UserCtrlImpl} es encargada de recibir las peticiones lanzadas
 * por el usuario desde la vista, se encarga de manejar y ejecutar los servicos
 * de un Usuario
 *
 * @author mont
 */
public class UserCtrlImpl implements UserCtrl {

    private static final Logger LOGGER = Logger.getLogger(UserCtrlImpl.class.getName());
    private UserService userService;

    @Override
    public UserVO iniciarSesion(UserVO userVO) {
        LOGGER.log(Level.INFO, "CTRL: Método iniciarSesion se ha iniciado");
        UserDTO userDTO = UserParser.parseToUserDTO(userVO);
        UserVO userVORecover = null;
        try {
            LOGGER.log(Level.INFO, "CTRL: Iniciando sesion");
            UserDTO userDTORecover=this.userService.iniciarSesion(userDTO);
            userVORecover = UserParser.parseToUserVO(userDTORecover);
            return userVORecover;
        } catch (UserAuthenticationException ex) {
            
        }
        LOGGER.log(Level.INFO, "CTRL: Método iniciarSesion ha Finalizado");
        if(userVORecover == null){
            userVORecover = new UserVO();
            userVORecover.setUserType(UserType.UKNOWN);
        }
        return userVORecover;
    }

    @Override
    public void cerrarSesion(UserVO userVO) {
        LOGGER.log(Level.INFO, "CTRL : Se ha iniciado el método cerrarSesion");
        UserDTO userDTO = UserParser.parseToUserDTO(userVO);
        this.userService.cerrarSesion(userDTO);
    }

    @Override
    public void bajaUsuario(String nickName) {
        LOGGER.log(Level.INFO, "UserCTRL: se ha iniciado el método bajaUsuario");
        this.userService.bajaUsuario(nickName);
        LOGGER.log(Level.INFO, "UserCTRL: ha finalizado el método bajaUsuario");
    }

    @Inject
    /**
     * @param userService El servicio a ser modificado
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
