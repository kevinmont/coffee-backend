package com.coffee.back.commons.exception;

/**
 *
 * @author mont
 */
@SuppressWarnings("serial")
public class BadRequest extends Exception{

    public BadRequest() {
        super();
    }
    
    public BadRequest(String error){
        super(error);
    }
}
