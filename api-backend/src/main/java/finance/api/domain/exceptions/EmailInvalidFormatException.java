package finance.api.domain.exceptions;

public class EmailInvalidFormatException extends IllegalArgumentException {
    public EmailInvalidFormatException() {
        super("The provided email format is invalid.");
    }

    public EmailInvalidFormatException(String message) {
        super(message);
    }

    public EmailInvalidFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailInvalidFormatException(Throwable cause) {
        super(cause);
    }
}


