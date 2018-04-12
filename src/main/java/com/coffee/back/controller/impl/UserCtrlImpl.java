package com.coffee.back.controller.impl;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.commons.exception.UserAunthenticationException;
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

	private static final Logger LOGGER = Logger.getLogger(UserCtrlImpl.class.getName());
	private UserService userService;

	@Override
	public void iniciarSesion(UserVO userVO) {
		LOGGER.log(Level.INFO, "CTRL: Método iniciarSesion se ha iniciado");

		UserDTO userDTO = UserParser.parseToUserDTO(userVO);

		try {
			LOGGER.log(Level.INFO, "CTRL: Método iniciarSesion designando vista");
			UserDTO intendUserDTO = this.getUserService().iniciarSesion(userDTO);
			switch (intendUserDTO.getUserType()) {
			case ADMINISTRADOR:
				// Mostrar vista Administrador
				break;
			case CAJERO:
				// Mostrar vista Cajero
				break;
			case UKNOWN:
				// Mostrar Mensaje error
				try {
					throw new Exception("El usuario es desconocido, datos incorrectos");
				} catch (Exception ex) {

				}
				break;
			}
			/**
			 * Controlador para el manejo de iniciar Sesion aqui designaras las vistas y
			 * como lo vas a representar
			 *
			 */
		} catch (UserAunthenticationException ex) {
			// Mandar mensaje de error de datos
			// mostra adventencias
		}
		LOGGER.log(Level.INFO, "CTRL: Método iniciarSesion ha Finalizado");
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
	
	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
