package se.kth.iv1350.pos.integration;

/**
 * Thrown when an item which does not exist in the itemCatalog is searched for
 */
public class ItemNotFoundException extends Exception{

    /**
     * A new instance for when item doesn't exist
     * @param itemID    the identifier for the item searched for
     */
    public ItemNotFoundException(String itemID){
        super("Item: "+ itemID + " does not exist in Item Catalog.");
    }
}
