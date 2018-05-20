package se.kth.iv1350.pos.model;

/**
 * A reciept class. Presents the saleinformation as a string for the Printer-class to print
 */
public class Reciept {
    private SaleInformation saleInformation;

    /**
     * A toString method to represent the SaleInformation to the printer
     * @return The string containing the reciept information
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Reciept Mystembolaget \n");
        builder.append(saleInformation.toString());
        builder.append("Cashier: Celine. Have a nice day :)");
        return builder.toString();
    }

    /**
     * Creator for saleinformation
     * @param saleInformation
     */
    public Reciept(SaleInformation saleInformation){

        this.saleInformation = saleInformation;
    }
}
