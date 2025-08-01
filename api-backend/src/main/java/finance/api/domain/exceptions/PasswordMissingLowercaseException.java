package finance.api.domain.exceptions;

public class PasswordMissingLowercaseException extends IllegalArgumentException {
    public PasswordMissingLowercaseException() {
        super("Password must contain at least one lowercase letter");
    }

    public PasswordMissingLowercaseException(String message) {
        super(message);
    }

    public PasswordMissingLowercaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordMissingLowercaseException(Throwable cause) {
        super(cause);
    }
}
