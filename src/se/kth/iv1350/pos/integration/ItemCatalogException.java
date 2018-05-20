package se.kth.iv1350.pos.integration;

/**
 * Thrown for exceptions in the ItemCatalog
 */
public class ItemCatalogException extends RuntimeException{
    /**
     *New instamce representing conditions from message
     * @param exceptionMessage  a message describing what went wrong
     */
    public ItemCatalogException(String exceptionMessage){
        super(exceptionMessage);
    }

    /**
     * New instance of an exception with message and cause
     * @param message   a message describing what went wrong
     * @param cause     the exception which caused the exception
     */

}
