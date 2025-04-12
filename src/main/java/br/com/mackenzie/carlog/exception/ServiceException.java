package br.com.mackenzie.carlog.exception;

public class ServiceException extends Exception {

    public ServiceException(String message) {
        super(message);
    }

    private static final long serialVersionUID = 1L;
}
