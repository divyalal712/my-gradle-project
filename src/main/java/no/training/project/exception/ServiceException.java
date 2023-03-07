package no.training.project.exception;

public class ServiceException extends RuntimeException {

    private String errorMessage;
    private int statusCode;

    public ServiceException(String errorMessage, int statusCode) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }
}

