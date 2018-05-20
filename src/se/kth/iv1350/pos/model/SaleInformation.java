package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.Item;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;
/**
 * A saleinformation class, represents the items in the current sale as an array list
 */
public class SaleInformation {
    private ArrayList items = new ArrayList();
    private Total total = new Total();
    private List<TotalObserver> totalObservers = new ArrayList<>();
    /**
     * Initializes a saleInfromation object
     */
    public SaleInformation(){

    }

    /**
     * Calculates how much change should be handed over
     * @param amountPaid    the amount of cash the customer hands over
     * @return              the change to be handed out
     */
    public int calculateChange(int amountPaid) {

        notifyObservers(total.getTotalPrice());
        return total.calculateChange(amountPaid);
    }

    /**
     * Takes an item and adds it to the current saleInformation
     * @param item  the item currently being added
     */
    public void updateSaleInformation(Item item) {
        items.add(item);
        total.addToTotal(item.getItemDescription());
    }

    /**
     * a get function for the total price of the purchase
     * @return  the total price of the purchase
     */
    public Total getTotal() {
        return total;
    }


    private void notifyObservers(int total){
        for (TotalObserver obs : totalObservers) {
            obs.newTotal(total);
        }
    }

    public void addTotalObservers(List<TotalObserver> observers) {
        totalObservers.addAll(observers);
    }

    /**
     * A function to display the items as a string instead of an arraylist
     * @return  the string with items
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < items.size(); i++) {
            builder.append(items.get(i).toString() + "\n");
        }
        builder.append(getTotal().toString());
        builder.append("\n");
        return builder.toString();
    }
}
