/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffee.back.controller.parser;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.controller.vo.UserVO;

/**
 *
 * @author mont
 */
public class UserParser {
    
    public UserDTO parseToUserDTO(UserVO userVO){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(userVO.getUser());
        userDTO.setPassword(userVO.getPassword());
        userDTO.setUserType(userVO.getUserType());
        return userDTO;
    }
    
    public UserVO parseToUserVO(UserDTO userDTO){
        UserVO userVO = new UserVO();
        userVO.setUser(userDTO.getUserName());
        userVO.setPassword(userDTO.getPassword());
        userVO.setUserType(userDTO.getUserType());
        return userVO;
    }
}
