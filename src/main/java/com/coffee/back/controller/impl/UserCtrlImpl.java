package com.coffee.back.controller.impl;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.controller.UserCtrl;
import com.coffee.back.controller.parser.UserParser;
import com.coffee.back.controller.vo.UserVO;
import com.coffee.back.service.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mont
 */
public class UserCtrlImpl implements UserCtrl {

    private static final Logger logger = Logger.getLogger(UserCtrlImpl.class.getName());

    private UserService userService;

    private UserParser userParse;

    @Override
    public void iniciarSesion(UserVO userVO) {
        logger.log(Level.INFO, "CTRL: Método iniciarSesion se ha iniciado");

        this.userParse = new UserParser();
        UserDTO userDTO = this.userParse.parseToUserDTO(userVO);
        
        try {
            logger.log(Level.INFO, "CTRL: Método iniciarSesion ha Finalizado");
            logger.log(Level.INFO, "CTRL: Método iniciarSesion designando vista");
            switch (this.userService.iniciarSesion(userDTO).getUserType()){
                case ADMINISTRADOR:
                        //Mostrar vista Administrador
                    break;
                case CAJERO:
                        //Mostrar vista Cajero
                    break;
                case UKNOWN:
                        //Mostrar Mensaje error
                    break;
            }
            /**
             * Controlador para el manejo de iniciar Sesion aqui designaras las
             * vistas y como lo vas a representar
             *
             */
            
        } catch (Exception ex) {
            
            //Mandar mensaje de error de datos
            //mostra adventencias
        }

        

    }

}
