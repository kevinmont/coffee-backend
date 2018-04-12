package com.coffee.back.commons.exception;

/**
 *
 * @author mont
 */
@SuppressWarnings("serial")
public class UserAunthenticationException extends Exception{

    public UserAunthenticationException() {
        
    }
    public UserAunthenticationException(String error){
        super(error);
    }
    
    
}
