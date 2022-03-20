package parking.lot.Exceptions;

public class TicketSystemException extends Exception{
    public TicketSystemException() {
        super();
    }

    public TicketSystemException(String message) {
        super(message);
    }

    public TicketSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public TicketSystemException(Throwable cause) {
        super(cause);
    }

    protected TicketSystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
