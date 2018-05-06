package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.AccountingSystem;
import se.kth.iv1350.pos.integration.DiscountCatalog;
import se.kth.iv1350.pos.integration.InventorySystem;
import se.kth.iv1350.pos.integration.ItemCatalog;
import se.kth.iv1350.pos.view.View;

/**
 * The main class, starts the application
 */
public class Main {
    /**
     * Starts the application
     * @param args  No command line parameters
     */
    public static void main(String [] args){
        ItemCatalog itemCatalog = new ItemCatalog();
        DiscountCatalog discountCatalog = new DiscountCatalog();
        InventorySystem inventorySystem = new InventorySystem();
        AccountingSystem accountingSystem = new AccountingSystem();
        Controller controller = new Controller(itemCatalog, discountCatalog, accountingSystem, inventorySystem);
        View view = new View(controller);
        view.sampleExecution();
    }
}
