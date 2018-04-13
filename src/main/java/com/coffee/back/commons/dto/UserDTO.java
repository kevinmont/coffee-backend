package com.coffee.back.commons.dto;

import com.coffee.back.commons.enums.UserType;

/**
 * Clase que representa los datos de un usuario para la transferencia
 * @author mont
 */
public class UserDTO {
    
    private String userName;    // Almacenara el nombre de usuario
    private String password;    // Almacenara el password de un usuario
    private UserType userType;  // Almacenara el tipo de usuario
    private Integer workerId;

    /**
     * @return El nombre de un usuario
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName El nombre de un usuario a modificar
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return El password de un usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password El password de usuario a modificar
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Recupera el id trabajador del usuario
     * @return {@code Integer} Id de trabajdor del usuario
     */
    public Integer getWorkerId() {
		return workerId;
	}
    
    /**
     * Modifica el id trabajador del usuario
     * @param workerId El id trabajador de un usuario
     */
	public void setWorkerId(Integer workerId) {
		this.workerId = workerId;
	}
	
    /**
     * @return El tipo de usuario
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * @param userType El tipo de usuario a modificar
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    
}
