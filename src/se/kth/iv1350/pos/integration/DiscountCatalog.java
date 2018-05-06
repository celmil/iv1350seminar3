package se.kth.iv1350.pos.integration;

import java.util.HashMap;

/**
 * Represents a discount catalog. In this code it is hard coded, but it could be a call to a database.
 * Class not used in the program at this time.
 */
public class DiscountCatalog {
    private int discountRule;
    private HashMap<String, Integer> discountCatalog = new HashMap();

    /**
     * Creates a discount catalog with two hard coded discounts in it. Could be replaced by a database call.
     */
    public DiscountCatalog(){
        discountCatalog.put("9504013928", 20);
        discountCatalog.put("9412246864", 15);
    }
    /**
     *Looks up what the discount rule for this customer is
     * @param customerID the customer identification string, eg. social security number
     * @return the discount rate, eg. 20 is 20% discount
     */
    public int lookUpDiscount(String customerID){
        discountRule = discountCatalog.get("customerID");
        return discountRule;
    }

}
