package se.kth.iv1350.pos.model;

public interface TotalObserver {
    /**
     * Happens when an item is added to a single purchases Total
     * @param total the price of what was added
     */
    void newTotal(int total);
}
