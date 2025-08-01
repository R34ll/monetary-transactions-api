package finance.api.domain.exceptions;


public class CpfNullOrBlankException extends IllegalArgumentException {
    public CpfNullOrBlankException() {
        super("CPF cannot be null or blank.");
    }

    public CpfNullOrBlankException(String message) {
        super(message);
    }

    public CpfNullOrBlankException(String message, Throwable cause) {
        super(message, cause);
    }

    public CpfNullOrBlankException(Throwable cause) {
        super(cause);
    }
}