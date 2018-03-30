package com.coffee.back.dao;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.commons.exception.BadRequest;
import com.coffee.back.dao.entity.User;

/**
 *
 * @author mont
 */
public interface UserDAO {
    
    User getUserByNickName(String user) throws BadRequest;
    
}
