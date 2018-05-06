package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Reciept;

/**
 * A printer, prints the reciept information.
 */
public class Printer {
    /**
     * Creates a printer
     */
    public Printer(){

    }

    /**
     * Prints the reciept
     * @param reciept   the current reciept
     */
    public void printReciept(Reciept reciept){
        System.out.println("The Reciept: " + reciept.toString());
    }
}
