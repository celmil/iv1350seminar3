package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.controller.OperationFailedException;
import se.kth.iv1350.pos.integration.ItemNotFoundException;

/**
 * the View class replaces an actual view with hard coded calls.
 */
public class View {
    private Controller controller;
    private ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();
    private LogHandler logHandler = new LogHandler();

    /**
     * creator for the view
     * @param controller    this view's controller
     */
    public View(Controller controller) {

        this.controller = controller;
        controller.addTotalObserver(new TotalRevenueView());
    }

    /**
     * A hard coded simulation of a sale
     */
    public void sampleExecution() {
        String itemTest1 = "666";
        String itemTest2 = "002";
        String itemTest3 = "005";
        String itemTest4 = "006";
        int amountPaid = 500;
        controller.startNewSale();
        try {

            System.out.println("//Trying to book item which causes database failure//");
            System.out.println(controller.registerItem(itemTest1));
        } catch (ItemNotFoundException itemNotFoundExc){
            handleException("Item not found in database ", itemNotFoundExc);
        } catch (OperationFailedException unknownExc) {
            handleException("Unknown error ", unknownExc);
        }
        try {
            System.out.println(controller.registerItem(itemTest2));
        } catch (ItemNotFoundException itemNotFoundExc){
            handleException("Item not found in database ", itemNotFoundExc);
        } catch (OperationFailedException unknownExc) {
            handleException("Unknown error ", unknownExc);
        }
        try {
            System.out.println(controller.registerItem(itemTest3));
        } catch (ItemNotFoundException itemNotFoundExc){
            handleException("Item not found in database ", itemNotFoundExc);
        } catch (OperationFailedException unknownExc){
            handleException("Unknown error ", unknownExc);
        }
        try {
            System.out.println("//Trying to register item which does not exist//");
            System.out.println(controller.registerItem(itemTest4));
        } catch (ItemNotFoundException itemNotFoundExc){
            handleException("Item not found exception ", itemNotFoundExc);
        } catch (OperationFailedException unknownExc){
            handleException("Unknown error ", unknownExc);
        }


        System.out.println("Sale completed. " + controller.displayTotalAndTax());
        System.out.println("Amount paid: " + amountPaid);
        System.out.println("Change to give: " + controller.pay(amountPaid));
        }
        private void handleException(String message, Exception exc){
            errorMessageHandler.showErrorMessage(message);
            logHandler.logException(exc);




    }
}
