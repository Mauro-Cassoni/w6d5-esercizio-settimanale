package it.epicode.w6d5.esercizio.settimanale.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}
