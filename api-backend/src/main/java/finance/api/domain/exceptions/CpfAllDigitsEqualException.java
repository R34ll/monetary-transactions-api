package finance.api.domain.exceptions;

public class CpfAllDigitsEqualException extends IllegalArgumentException {
    public CpfAllDigitsEqualException() {
        super("CPF cannot have all digits equal.");
    }

    public CpfAllDigitsEqualException(String message) {
        super(message);
    }

    public CpfAllDigitsEqualException(String message, Throwable cause) {
        super(message, cause);
    }

    public CpfAllDigitsEqualException(Throwable cause) {
        super(cause);
    }
}
