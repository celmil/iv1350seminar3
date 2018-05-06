package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.SaleInformation;

/**
 * A representation of an Inventory system. Could be replaced with an external system call.
 */
public class InventorySystem {
    /**
     * A hard coded placeholder for sending the SaleInformation to the InventorySystem
     * @param saleInformation   The current sale's SaleInformation
     */
    public void inventory(SaleInformation saleInformation){
        System.out.println(" External InventorySystem has recieved SaleInformation ");
    }
}
