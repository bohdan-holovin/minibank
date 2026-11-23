package org.holovin.minibank.domain.exception;

public class InactiveAccountException extends RuntimeException {

    public InactiveAccountException(String message) {
        super(message);
    }
}
