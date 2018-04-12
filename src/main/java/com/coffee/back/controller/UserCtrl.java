package com.coffee.back.controller;

import com.coffee.back.controller.vo.UserVO;

/**
 *
 * @author mont
 */
public interface UserCtrl {
    
    /**
     * Indica el inicio de sesión.
     * @param userVO estado del objeto que intenta iniciar sesion
     */
    void iniciarSesion(UserVO userVO);
    
    /**
     * Indica el cierre de sesión. 
     * @param userVO estado del objeto actual en el sistema.
     */
    void cerrarSesion(UserVO userVO);
     
    /**
     * Eliminar a un usuario almacenado en el sistema
     * @param nickName Identifica a un usuario capaz de iniciar sesion
     */
    void bajaUsuario(String nickName);
}
