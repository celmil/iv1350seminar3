package se.kth.iv1350.pos.controller;

/**
 * Throws for operation failures when the reason is unknown
 */
public class OperationFailedException extends Exception{
    /**
     * A new instance for an exception with unknown reason
     * @param message           exception message
     * @param causeOfException  the exception that caused the exception
     */
    public OperationFailedException(String message, Exception causeOfException){
        super(message, causeOfException);
    }
}
