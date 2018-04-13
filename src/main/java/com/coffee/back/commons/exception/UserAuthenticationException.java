package com.coffee.back.commons.exception;

/**
 * La clase {@code UserAuthenticationException} se lanza para indicar que un usuario ha intentado
 * acceder a un servicio pero los datos son incorrectos
 * @author mont
 */
public class UserAuthenticationException extends Exception{

	private static final long serialVersionUID = 1L;
	public UserAuthenticationException() {
        super();
    }
    public UserAuthenticationException(String error){
        super(error);
    }
    
    
}
