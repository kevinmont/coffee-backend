package com.coffee.back.dao;

import com.coffee.back.commons.enums.UserType;

/**
 *
 * @author mont
 */
public interface WorkerDAO {
    
    /**
     * Recupera el role de un usuario 
     * @param workerId identificador perteneciente a un usuario
     * @return {@code UserType} que indentifica el rol del usuario 
     */
    UserType getRoleNameByWorkerId(Integer workerId);
    
}
