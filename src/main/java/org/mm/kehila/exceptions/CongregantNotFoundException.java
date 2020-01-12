package org.mm.kehila.exceptions;

public class CongregantNotFoundException extends RuntimeException {
    static final long serialVersionUID = 1;
 
    public CongregantNotFoundException(){
        super();
    }

    public CongregantNotFoundException(String message){
        super(message);
    }

    public CongregantNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}