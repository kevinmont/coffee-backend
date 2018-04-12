package com.coffee.back.service;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.commons.exception.UserAunthenticationException;

/**
 *
 * @author mont
 */
public interface UserService {

    UserDTO iniciarSesion(UserDTO userDTO) throws UserAunthenticationException;

    /**
     * Cierra la sesión actual en el sistema
     *
     * @param userDTO representa el estado del usuario actual en el sistema
     * @return {@code true} si el usuario es un administrador, {@code false} de
     * lo contrario
     */
    boolean cerrarSesion(UserDTO userDTO);

    String altaUsuario(UserDTO userDTO);
    
    /**
     * Elimina a un usuario existente en el sistema
     * @param nickName Identifica a un usuario capaz de iniciar sesion
     * @return {@code String} Indica el estatus de la operación
     */
    String bajaUsuario(String nickName);

    String modificarUsuario(UserDTO userDTO);

}
