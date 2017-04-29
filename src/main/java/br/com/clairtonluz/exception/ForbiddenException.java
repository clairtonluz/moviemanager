package br.com.clairtonluz.exception;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException() {
        super("Permissão negada");
    }

    public ForbiddenException(String message) {
        super(message);
    }
}
