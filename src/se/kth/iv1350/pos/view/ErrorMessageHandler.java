package se.kth.iv1350.pos.view;

/**
 * Shows error messages for the user, in this case the cashier
 */
public class ErrorMessageHandler {
    /**
     *  Displays via sysout the error message
     * @param message
     */
    void showErrorMessage(String message){
        StringBuilder errorMessageBuilder = new StringBuilder();
        errorMessageBuilder.append(" -ERROR- ");
        errorMessageBuilder.append(message);
        System.out.println(errorMessageBuilder);
    }
}
