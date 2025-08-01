package finance.api.domain.exceptions;


public class PasswordMissingSpecialCharacterException extends IllegalArgumentException {
    public PasswordMissingSpecialCharacterException() {
        super("Password must contain at least one special character");
    }

    public PasswordMissingSpecialCharacterException(String message) {
        super(message);
    }

    public PasswordMissingSpecialCharacterException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordMissingSpecialCharacterException(Throwable cause) {
        super(cause);
    }
}