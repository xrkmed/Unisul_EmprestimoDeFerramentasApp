package Exceptions;

public class CNPJNotFound extends Exception {

    public CNPJNotFound(String message) {
        super(message);
    }

    public CNPJNotFound() {
        super("CNPJ not found");
    }
}
