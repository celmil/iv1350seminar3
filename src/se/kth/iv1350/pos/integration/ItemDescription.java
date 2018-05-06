package se.kth.iv1350.pos.integration;

/**
 * The ItemDescription class represents an ItemDescription, containing the name of an item, the price of said item, and the item's tax rate
 */
public class ItemDescription {
    private double tax;
    private int price;
    private String itemName;

    /**
     * get method for the components of ItemDescription
     * @param price     the price of the item in int
     * @param tax       the tax of the item in double
     * @param itemName  the name of the item in string
     */
    public ItemDescription(String itemName, int price, double tax) {
        this.itemName = itemName;
        this.price = price;
        this.tax = tax;
    }

    /**
     * get method for the price
     * @return  the price of the item in int
     */
    public int getPrice(){

        return this.price;
    }

    /**
     * get method for the tax
     * @return  the taxrate of the item in double
     */
    public double getTax(){

        return this.tax;
    }

    /**
     * toString method for printing the item name, price and tax rate
     * @return a string with the name, price and tax of the item
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(itemName + " " + price + "kr " + tax + "% ");
        return builder.toString();
    }
}
