package com.coffee.back.commons.exception;

/**
 *
 * @author mont
 */
public class UserAunthenticationException extends Exception{

    public UserAunthenticationException() {
        
    }
    public UserAunthenticationException(String error){
        super(error);
    }
    
    
}
