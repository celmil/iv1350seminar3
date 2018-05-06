package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;

/**
 * the View class replaces an actual view with hard coded calls.
 */
public class View {
    private Controller controller;

    /**
     * creator for the view
     * @param controller    this view's controller
     */
    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * A hard coded simulation of a sale
     */
    public void sampleExecution() {
        String itemTest1 = "001";
        String itemTest2 = "002";
        String itemTest3 = "005";
        int amountPaid = 500;
        controller.startNewSale();
        System.out.println(controller.registerItem(itemTest1));
        System.out.println(controller.registerItem(itemTest2));
        System.out.println(controller.registerItem(itemTest3));

        System.out.println("Sale completed. " + controller.displayTotalAndTax());
        System.out.println("Amount paid: " + amountPaid);
        System.out.println("Change to give: " + controller.pay(amountPaid));





    }
}
