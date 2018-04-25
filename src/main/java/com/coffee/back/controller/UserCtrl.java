package com.coffee.back.controller;

import com.coffee.back.controller.vo.UserVO;

/**
 * La interfaz {@code UserCtrl} es encargada de recibir las peticiones lanzadas por el 
 * usuario desde la vista, se encarga de manejar y ejecutar los servicos de un Usuario
 * @author mont
 */
public interface UserCtrl {
    
    /**
     * Indica el inicio de sesión.
     * @param userVO estado del objeto que intenta iniciar sesion
     * @return UserVO el modelo recuperado de un usuario
     */
    UserVO iniciarSesion(UserVO userVO);
    
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
