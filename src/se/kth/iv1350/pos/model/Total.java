package se.kth.iv1350.pos.model;


import se.kth.iv1350.pos.integration.ItemDescription;

/**
 * A class total which provides the purchases total price and total tax
 */
public class Total {
    private int totalPrice;
    private double totalTax;
    private int PERCENTAGE_CALCULATOR = 100;

    /**
     * adds an item's price and tax to the totalprice and totaltax
     * @param itemDescription   the current item's itemDescription
     */
    public void addToTotal(ItemDescription itemDescription){
        totalPrice = totalPrice + itemDescription.getPrice();
        double taxOfItem = (double) itemDescription.getPrice() * ((itemDescription.getTax()/PERCENTAGE_CALCULATOR));
        totalTax = totalTax + taxOfItem;
    }

    /**
     * a get function for the total price of the purchase
     * @return  the total price of the purchase
     */
    public int getTotalPrice(){

        return this.totalPrice;
    }
    /**
     * a get function for the total tax of the purchase
     * @return  the total tax of the purchase
     */
    public double getTotalTax(){

        return this.totalTax;
    }

    /**
     * Calculates the amount of change to be given to the customer
     * @param amountPaid    how much cash the customer hands over
     * @return              the amount of change to be given
     */
    public int calculateChange(int amountPaid){
        int change = amountPaid - getTotalPrice();
        return change;
    }

    /**
     * A toString to display the total price as a String
     * @return     a String with total price and total tax in it
     */
    @Override
    public String toString() {
        return "Total: " + Integer.toString(totalPrice) + "\nTotal tax: " + Double.toString(totalTax);
    }

}