package com.coffee.back.controller.vo;

import com.coffee.back.commons.enums.UserType;

/**
 * Clase que representa el modelo de un usuario
 *
 * @author mont
 */
public class UserVO {

    private String userName;    // Almacenara el nombre de usuario
    private String password;    // Almacenara el password de un usuario
    private UserType userType;  // Almacenara el tipo de usuario

    /**
     * Recupera el nombre.
     *
     * @return El nombre de un usuario
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Configura el nombre.
     *
     * @param userName El nombre de un usuario a modificar
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Recupera el password
     *
     * @return El password de un usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Configura el password.
     *
     * @param password El password de usuario a modificar
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Recupera el tipo al que pertenece el usuario.
     *
     * @return El tipo de usuario
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Configura el tipo al que pertenece el usuario.
     *
     * @param userType El tipo de usuario a modificar
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

}
