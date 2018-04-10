package com.coffee.back.dao;

import com.coffee.back.commons.enums.UserType;

/**
 * Interfaz {@code WorkerDAO} encargada de establecer solicitudes con el servidor
 * de la base de datos de tipo CRUD
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
