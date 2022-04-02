package com.phone.Exceptions;

public class ContactManagerException extends RuntimeException {
    public ContactManagerException() {
        super();
    }

    public ContactManagerException(String message) {
        super(message);
    }

    public ContactManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContactManagerException(Throwable cause) {
        super(cause);
    }

    protected ContactManagerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
