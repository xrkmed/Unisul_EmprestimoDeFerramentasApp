package Exceptions;

public class ToolNotFound extends Exception {

    public ToolNotFound(String message) {
        super(message);
    }

    public ToolNotFound() {
        super("ERROR: Tool not found.");
    }
}
