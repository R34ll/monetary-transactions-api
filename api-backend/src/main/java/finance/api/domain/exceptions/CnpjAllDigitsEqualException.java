package finance.api.domain.exceptions;

public class CnpjAllDigitsEqualException extends IllegalArgumentException {
    public CnpjAllDigitsEqualException() {
        super("CNPJ cannot have all digits equal.");
    }

    public CnpjAllDigitsEqualException(String message) {
        super(message);
    }

    public CnpjAllDigitsEqualException(String message, Throwable cause) {
        super(message, cause);
    }

    public CnpjAllDigitsEqualException(Throwable cause) {
        super(cause);
    }
}
