package finance.api.domain.exceptions;


public class PasswordMissingUppercaseException extends IllegalArgumentException {
    public PasswordMissingUppercaseException() {
        super("Password must contain at least one uppercase letter");
    }

    public PasswordMissingUppercaseException(String message) {
        super(message);
    }

    public PasswordMissingUppercaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordMissingUppercaseException(Throwable cause) {
        super(cause);
    }
}
