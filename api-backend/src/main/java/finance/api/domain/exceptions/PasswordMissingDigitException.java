package finance.api.domain.exceptions;

public class PasswordMissingDigitException extends IllegalArgumentException {
    public PasswordMissingDigitException() {
        super("Password must contain at least one digit");
    }

    public PasswordMissingDigitException(String message) {
        super(message);
    }

    public PasswordMissingDigitException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordMissingDigitException(Throwable cause) {
        super(cause);
    }
}
