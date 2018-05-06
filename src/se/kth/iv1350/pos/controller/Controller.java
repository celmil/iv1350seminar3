package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.Reciept;
import se.kth.iv1350.pos.model.SaleInformation;

/**
 * The controller communicates with the components in the different layers.
 */
public class Controller {
    private ItemCatalog itemCatalog;
    private DiscountCatalog discountCatalog;
    private SaleInformation saleInformation;
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;

    /**
     * Creator for the Controller
     * @param itemCatalog       the itemCatalog "database"
     * @param discountCatalog   the discountCatalog "database"
     * @param accountingSystem  the representation of an accounting system
     * @param inventorySystem   the representation of an inventory system
     */
    public Controller(ItemCatalog itemCatalog, DiscountCatalog discountCatalog, AccountingSystem accountingSystem, InventorySystem inventorySystem){
        this.itemCatalog = itemCatalog;
        this.discountCatalog = discountCatalog;
        this.accountingSystem = accountingSystem;
        this.inventorySystem = inventorySystem;

    }

    /**
     * Starts a new sale, with a new sale information
     */
    public void startNewSale(){

        this.saleInformation = new SaleInformation();
    }

    /**
     * Registers an item, creates a string with the information and updates the saleInformation via a call to saleInformation
     * @param itemIdentifier    the item identifier, eg. a barcode
     * @return                  a String to be displayed through the view
     */
    public String registerItem(String itemIdentifier){
        String informationToDisplay = "";
        informationToDisplay.concat(" " + itemCatalog.getItemDescription(itemIdentifier));
        informationToDisplay.concat(" Total:" + saleInformation.getTotal().getTotalPrice());
        Item item = new Item(itemIdentifier, itemCatalog.getItemDescription(itemIdentifier));
        saleInformation.updateSaleInformation(item);
        return informationToDisplay;
    }

    /**
     * Displays a completed sales total and tax as a string
     * @return  a string containing the sales total and tax
     */
    public String displayTotalAndTax(){
        String totalAndTax = "";
        totalAndTax.concat("Total: " + saleInformation.getTotal().getTotalPrice() + "\n Tax: " + saleInformation.getTotal().getTotalTax());
        return totalAndTax;
    }

    /**
     * Pay method, pays the current sale with the cash recieved from the customer and calculates change to give
     * @param amountPaid    how much cash the customer gives
     * @return              a String containing the change to give back
     */
    public String pay(int amountPaid){
        accountingSystem.bookKeep(saleInformation);
        inventorySystem.inventory(saleInformation);
        Reciept reciept = new Reciept(saleInformation);
        Printer printer = new Printer();
        printer.printReciept(reciept);
        CashRegister cashRegister = new CashRegister();
        cashRegister.updateBalance(saleInformation.getTotal());

        return Integer.toString(saleInformation.calculateChange(amountPaid));
    }



}
