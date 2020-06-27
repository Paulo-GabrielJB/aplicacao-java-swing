package br.com.paulo.swing.exceptions;


public class StandardException extends RuntimeException {
    
    public StandardException(String msg){
        super(msg);
    }
    
    public StandardException(Throwable throwable){
        super(throwable);
    }
    
    public StandardException(String msg, Throwable throwable){
        super(msg, throwable);
    }
    
}
