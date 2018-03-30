package com.coffee.back.service;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.commons.exception.UserAunthenticationException;

/**
 *
 * @author mont
 */
public interface UserService {
    
    UserDTO iniciarSesion(UserDTO userDTO) throws UserAunthenticationException;
    
    void cerrarSesion(UserDTO userDTO);
    
    void altaUsuario();
    
    void bajaUsuario();
    
    void modificarUsuario();
    
    
}
