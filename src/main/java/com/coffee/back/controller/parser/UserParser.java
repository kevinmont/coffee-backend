package com.coffee.back.controller.parser;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.commons.enums.UserType;
import com.coffee.back.controller.vo.UserVO;

/**
 * Clase parseadora de utilidad
 *
 * @author mont
 */
public class UserParser {

    /**
     * Parsea un {@code UserVO} a un {@code UserDTO}
     *
     * @param userVO Objeto a ser parseado
     * @return {@code UserDTO} objeto parseado
     */
    public static UserDTO parseToUserDTO(UserVO userVO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(userVO.getUserName());
        userDTO.setPassword(userVO.getPassword());
        if (userVO.getUserType() == null) {
            userDTO.setUserType(UserType.UKNOWN);
        } else {
            userDTO.setUserType(userVO.getUserType());
        }
        return userDTO;
    }

    /**
     * Parsea un {@code UserDTO} a un {@code UserVO}
     *
     * @param userDTO Objeto a ser parseado
     * @return {@code userVO} objeto parseado
     */
    public static UserVO parseToUserVO(UserDTO userDTO) {
        UserVO userVO = new UserVO();
        userVO.setUserName(userDTO.getUserName());
        userVO.setPassword(userDTO.getPassword());
        userVO.setUserType(userDTO.getUserType());
        return userVO;
    }
}
