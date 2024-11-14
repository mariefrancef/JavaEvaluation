package fritz.mariefrance.exception;

public class CreateBikeException extends Exception {

    public CreateBikeException(String message) {
        super(message);
    }

    public CreateBikeException(String message, Throwable cause) {
        super(message, cause);
    }
}
