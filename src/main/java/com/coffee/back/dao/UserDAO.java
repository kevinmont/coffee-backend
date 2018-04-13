package com.coffee.back.dao;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.commons.exception.BadRequestException;;

/**
 * Interfaz {@code UserDAO} encargada de establecer solicitudes con el servidor
 * de la base de datos de tipo CRUD
 * 
 * @author mont
 */
public interface UserDAO {

	/**
	 * Consigue un usuario registrado en el sistema
	 * @param user identificador unico del usuario a ser buscado
	 * @return {@Code User} que se encuentra registrado en el sistema
	 * @throws BadRequestException si el usuario no existe o campos incompletos
	 */
	UserDTO getUserByNickName(String user) throws BadRequestException;

	boolean delete(String nickName);
}
