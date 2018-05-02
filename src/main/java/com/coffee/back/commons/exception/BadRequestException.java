package com.coffee.back.commons.exception;

/**
 * La clase {@code BadRequestException} se lanza para indicar que un método se le ha pasado 
 * una petición incorrecta
 * @author mont
 */
public class BadRequestException extends Exception{

    public BadRequestException() {
        super();
    }
    
    public BadRequestException(String error){
        super(error); // Se construye el constructor de Exception(String error)
    }
}
