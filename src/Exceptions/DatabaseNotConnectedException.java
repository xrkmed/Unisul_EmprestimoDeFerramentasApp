package Exceptions;

public class DatabaseNotConnectedException extends RuntimeException {

    public DatabaseNotConnectedException(String msg) {
        super(msg);
    }

    public DatabaseNotConnectedException() {
        super("Banco de dados nao esta conectado.");
    }
}
