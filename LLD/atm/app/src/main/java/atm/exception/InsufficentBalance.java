package atm.exception;

public class InsufficentBalance extends Exception {
    public InsufficentBalance() {
        super();
    }

    public InsufficentBalance(String message) {
        super(message);
    }

    public InsufficentBalance(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficentBalance(Throwable cause) {
        super(cause);
    }

    protected InsufficentBalance(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
