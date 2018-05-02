package com.coffee.back.commons.exception;

/**
 * La clase {@code NotFoundException} es lanzando cuando se intenta buscar algun
 * registro y está no es encontrada.
 *
 * @author mont
 */
public class NotFoundException extends Exception {

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

}
