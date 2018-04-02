package com.coffee.back.dao;

import com.coffee.back.commons.enums.UserType;

/**
 *
 * @author mont
 */
public interface WorkerDAO {
    
    UserType getRoleNameByWorkerId(Integer workerId);
    
}
