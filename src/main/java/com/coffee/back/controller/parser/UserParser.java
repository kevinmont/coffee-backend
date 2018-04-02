package com.coffee.back.controller.parser;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.controller.vo.UserVO;

/**
 *
 * @author mont
 */
public class UserParser {
    
    public static UserDTO parseToUserDTO(UserVO userVO){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(userVO.getUser());
        userDTO.setPassword(userVO.getPassword());
        userDTO.setUserType(userVO.getUserType());
        return userDTO;
    }
    
    public static UserVO parseToUserVO(UserDTO userDTO){
        UserVO userVO = new UserVO();
        userVO.setUser(userDTO.getUserName());
        userVO.setPassword(userDTO.getPassword());
        userVO.setUserType(userDTO.getUserType());
        return userVO;
    }
}
