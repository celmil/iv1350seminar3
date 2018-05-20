package se.kth.iv1350.pos.integration;

import java.util.HashMap;

/**
 * The ItemCatalog class contains the "database" of items. Here they are hard coded into the program for simplicity's sake.
 */
public class ItemCatalog {
    private ItemDescription itemDescription = new ItemDescription("Item does not exist", 0, 0);
    private HashMap<String, ItemDescription> itemCatalog = new HashMap();

    /**
     * creates an ItemCatalog. Could be replaced by a call to a data base
     */
    public ItemCatalog(){
        itemCatalog.put("001", new ItemDescription("Sake", 93, 25));
        itemCatalog.put("002", new ItemDescription("Grappa", 320, 25));
        itemCatalog.put("003", new ItemDescription("Mjöd", 57, 25));
        itemCatalog.put("004", new ItemDescription("Julmust", 32, 12));
        itemCatalog.put("005", new ItemDescription("Sanbitter", 10, 12));
        itemCatalog.put("666", new ItemDescription("ItemWhichCausesDataBaseFailure", 0, 0));
    }

    /**
     * Gets the item description from the itemCatalog
     * @param identifier    the identifier for the item, eg. barcode
     * @return
     */
    public ItemDescription getItemDescription(String identifier) throws ItemNotFoundException{
        if(!itemCatalog.containsKey(identifier)) {
            throw new ItemNotFoundException(identifier);
        }
        itemDescription = itemCatalog.get(identifier);
        return itemDescription;
    }

}
