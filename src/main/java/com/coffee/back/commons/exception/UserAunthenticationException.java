package com.coffee.back.commons.exception;

/**
 *
 * @author mont
 */
public class UserAunthenticationException extends Exception{

    public UserAunthenticationException() {
        super();
    }
    public UserAunthenticationException(String error){
        super(error);
    }
    
    
}
