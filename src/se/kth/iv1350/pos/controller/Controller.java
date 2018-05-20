package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.Reciept;
import se.kth.iv1350.pos.model.SaleInformation;
import se.kth.iv1350.pos.model.TotalObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * The controller communicates with the components in the different layers.
 */
public class Controller {
    private ItemCatalog itemCatalog;
    private SaleInformation saleInformation;
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private List<TotalObserver> totalObservers = new ArrayList<>();

    /**
     * Creator for the Controller
     * @param itemCatalog       the itemCatalog "database"
     * @param accountingSystem  the representation of an accounting system
     * @param inventorySystem   the representation of an inventory system
     */
    public Controller(ItemCatalog itemCatalog, AccountingSystem accountingSystem, InventorySystem inventorySystem){
        this.itemCatalog = itemCatalog;
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
    public String registerItem(String itemIdentifier) throws ItemNotFoundException, OperationFailedException{
        String informationToDisplay = "";
        try {
            if (itemIdentifier.equals("666")){
                throw new ItemCatalogException("Database failure");
            }
            informationToDisplay.concat(" " + itemCatalog.getItemDescription(itemIdentifier));
        } catch (ItemCatalogException itemCatalogExc) {
            throw new OperationFailedException("Could not access item from database. ", itemCatalogExc);
        }
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
        saleInformation.addTotalObservers(totalObservers);
        cashRegister.updateBalance(saleInformation.getTotal());
        return Integer.toString(saleInformation.calculateChange(amountPaid));
    }
    public void addTotalObserver(TotalObserver obs){
        totalObservers.add(obs);
    }



}
