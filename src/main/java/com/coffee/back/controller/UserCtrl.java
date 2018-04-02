package com.coffee.back.controller;

import com.coffee.back.controller.vo.UserVO;

/**
 *
 * @author mont
 */
public interface UserCtrl {
    
    void iniciarSesion(UserVO userVO);
    
    void cerrarSesion(UserVO userVO);
       
}
