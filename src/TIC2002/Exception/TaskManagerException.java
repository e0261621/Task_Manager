package TIC2002.Exception;

/**
 * Generates an exception when called and passes the message to the caller.
 */
public class TaskManagerException extends Exception {
    public TaskManagerException(String message) {
        super(message);
    }
}
