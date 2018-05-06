package se.kth.iv1350.pos.integration;

/**
 * The class Item represents an item with an ItemDescription and an Item identifier
 */
public class Item {

    private String identifier;
    private ItemDescription itemDescription;

    /**
     *Creates a new data object for a specific Item
     * @param identifier        The items identifier
     * @param itemDescription   The items description, containing price per unit, item name, and item taxrate
     */
    public Item(String identifier, ItemDescription itemDescription) {

        this.identifier = identifier;
        this.itemDescription = itemDescription;
    }

    /**
     * a get function for the ItemDescription of an Item
     * @return
     */
    public ItemDescription getItemDescription(){

        return this.itemDescription;
    }

    /**
     * A toString function to represent the item's identifier and description as strings for the Reciept
     * @return a string with the identifier and description of the current item
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Identifier: " + identifier);
        builder.append("Item: " + itemDescription.toString());
        return builder.toString();
    }
}
