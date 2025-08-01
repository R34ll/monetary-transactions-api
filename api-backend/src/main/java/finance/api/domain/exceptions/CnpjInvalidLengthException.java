package finance.api.domain.exceptions;

public class CnpjInvalidLengthException extends IllegalArgumentException {
    public CnpjInvalidLengthException() {
        super("CNPJ must contain exactly 14 digits.");
    }

    public CnpjInvalidLengthException(String message) {
        super(message);
    }

    public CnpjInvalidLengthException(String message, Throwable cause) {
        super(message, cause);
    }

    public CnpjInvalidLengthException(Throwable cause) {
        super(cause);
    }
}

