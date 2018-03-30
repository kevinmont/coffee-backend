/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffee.back.commons.exception;

/**
 *
 * @author mont
 */
public class BadRequest extends Exception{

    public BadRequest() {
        super();
    }
    
    public BadRequest(String error){
        super(error);
    }
}
