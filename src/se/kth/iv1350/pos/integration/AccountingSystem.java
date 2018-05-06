package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.SaleInformation;

/**
 * A representation of an accounting system. Could be replaced by an external accounting system call
 */
public class AccountingSystem {
    /**
     * A hard coded placeholder for sending the SaleInformation to the AccountingSystem
     * @param saleInformation   The current sale's SaleInformation
     */
    public void bookKeep(SaleInformation saleInformation){
        System.out.println(" External accounting system has recieved SaleInformation ");
    }
}
