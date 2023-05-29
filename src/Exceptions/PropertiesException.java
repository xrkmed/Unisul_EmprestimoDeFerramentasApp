package Exceptions;

public class PropertiesException extends RuntimeException {

    public PropertiesException(String msg) {
        super(msg);
    }

    public PropertiesException() {
        super("Erro ao carregar o arquivo de propriedades.");
    }
}
