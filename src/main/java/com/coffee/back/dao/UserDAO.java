package com.coffee.back.dao;

import com.coffee.back.commons.exception.BadRequest;
import com.coffee.back.dao.entity.User;

/**
 *
 * @author mont
 */
public interface UserDAO {

    /**
     * 
     * @param user identificador unico del usuario a ser buscado 
     * @return {@Code User} que se encuentra registrado en el sistema 
     * @throws BadRequest si el usuario no existe o campos incompletos
     */
    User getUserByNickName(String user) throws BadRequest;

}
