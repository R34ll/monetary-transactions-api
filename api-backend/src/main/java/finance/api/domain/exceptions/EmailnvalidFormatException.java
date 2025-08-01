public class EmailInvalidFormatException extends DomainException {
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


