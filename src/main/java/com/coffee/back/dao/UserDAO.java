package com.coffee.back.dao;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.commons.exception.BadRequest;

/**
 *
 * @author mont
 */
public interface UserDAO {

    UserDTO getUserByNickName(String user) throws BadRequest;
    
    boolean delete(String nickName);
}
