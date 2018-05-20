package se.kth.iv1350.pos.view;

/**
 * A class for the logging
 */
public class LogHandler {
    /**
     * Writes out a log entry on the sysout
     * @param exception the exception that was thrown for the entry
     */
    public void logException(Exception exception){
        StringBuilder logHandlerMsgBuilder = new StringBuilder();
        logHandlerMsgBuilder.append(" LOG --Exception was thrown: ");
        logHandlerMsgBuilder.append(exception.getMessage());
        logHandlerMsgBuilder.append(" -- LOG");
        System.out.println(logHandlerMsgBuilder);
    }
}
