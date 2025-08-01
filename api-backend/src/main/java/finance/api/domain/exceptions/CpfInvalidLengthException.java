package finance.api.domain.exceptions;

public class CpfInvalidLengthException extends IllegalArgumentException {
    public CpfInvalidLengthException() {
        super("CPF must contain exactly 11 digits.");
    }

    public CpfInvalidLengthException(String message) {
        super(message);
    }

    public CpfInvalidLengthException(String message, Throwable cause) {
        super(message, cause);
    }

    public CpfInvalidLengthException(Throwable cause) {
        super(cause);
    }
}

