package br.com.clairtonluz.exception;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException() {
        super("Operação não permitida");
    }

    public ForbiddenException(String message) {
        super(message);
    }
}
