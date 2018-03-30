/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffee.back.controller;

import com.coffee.back.controller.vo.UserVO;

/**
 *
 * @author mont
 */
public interface UserCtrl {
    
    void iniciarSesion(UserVO userVO);
}
