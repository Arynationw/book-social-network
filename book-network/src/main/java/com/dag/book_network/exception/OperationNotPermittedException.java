package com.dag.book_network.exception;

public class OperationNotPermittedException extends RuntimeException {
    public OperationNotPermittedException(String msg){
        super(msg);
    }
}