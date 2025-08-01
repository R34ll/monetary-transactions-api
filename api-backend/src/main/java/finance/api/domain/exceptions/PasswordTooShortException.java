package finance.api.domain.exceptions;


public class PasswordTooShortException extends IllegalArgumentException {
    public PasswordTooShortException() {
        super("Password must be at least 8 characters long");

    }

    public PasswordTooShortException(String message) {
        super(message);
    }

    public PasswordTooShortException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordTooShortException(Throwable cause) {
        super(cause);
    }
}