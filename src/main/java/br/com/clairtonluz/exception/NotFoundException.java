package br.com.clairtonluz.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Recurso não encontrado");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
