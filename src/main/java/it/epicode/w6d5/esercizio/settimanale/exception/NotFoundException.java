package it.epicode.w6d5.esercizio.settimanale.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
