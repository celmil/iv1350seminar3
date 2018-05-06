package se.kth.iv1350.pos.model;

/**
 * a Cash register containing the balance of the cash register
 */
public class CashRegister {
    private int balance = 1000;

    /**
     * Creates a CashRegister
     */
    public CashRegister(){

    }

    /**
     * Adds the payment to the balance
     * @param total     the total price of the current purchase
     */
    public void updateBalance(Total total){
        balance += total.getTotalPrice();
    }
}
