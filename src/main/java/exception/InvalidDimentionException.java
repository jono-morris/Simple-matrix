package exception;

public class InvalidDimentionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidDimentionException(String message) {
        super(message);
    }
}
