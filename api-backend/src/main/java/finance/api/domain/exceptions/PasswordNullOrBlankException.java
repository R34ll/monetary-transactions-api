package finance.api.domain.exceptions;

public class PasswordNullOrBlankException extends IllegalArgumentException{
    public PasswordNullOrBlankException() {
        super("Password cannot be null or blank");
    }

    public PasswordNullOrBlankException(String message) {
        super(message);
    }

    public PasswordNullOrBlankException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNullOrBlankException(Throwable cause) {
        super(cause);
    }
}