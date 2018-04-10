package com.coffee.back.controller;

import com.coffee.back.controller.vo.UserVO;

/**
 * La clase {@code UserCtrl} es encargada de recibir las peticiones lanzadas por el 
 * usuario desde la vista, se encarga de manejar y ejecutar los servicos de un Usuario
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
      
}
