package org.poker.pokerGauss.v1.exceptions;

public class DefaultException {
    private final long statusCode;
    private final String errorMessage;

    public DefaultException(long statusCode, String errorMessage) {
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public long getStatusCode() {
        return statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
