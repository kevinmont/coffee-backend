package com.coffee.back.commons.exception;

/**
 *
 * @author mont
 */
@SuppressWarnings("serial")
public class UserException extends Exception{

    public UserException() {
        
    }
    
    public UserException(String userException) {
        super(userException);
    }
    
}
