package atm.exception;

public class IncorrectPin extends Exception {
    public IncorrectPin() {
        super();
    }

    public IncorrectPin(String message) {
        super(message);
    }

    public IncorrectPin(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectPin(Throwable cause) {
        super(cause);
    }

    protected IncorrectPin(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
