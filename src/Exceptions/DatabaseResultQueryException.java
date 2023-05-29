package Exceptions;

public class DatabaseResultQueryException extends Exception {

    public DatabaseResultQueryException(String message) {
        super(message);
    }

    public DatabaseResultQueryException() {
        super("Erro ao executar a query no banco de dados!");
    }
}
