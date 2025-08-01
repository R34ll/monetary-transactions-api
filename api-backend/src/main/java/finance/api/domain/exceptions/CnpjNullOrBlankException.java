package finance.api.domain.exceptions;

public class CnpjNullOrBlankException extends IllegalArgumentException {
    public CnpjNullOrBlankException() {
        super("CNPJ cannot be null or blank.");
    }

    public CnpjNullOrBlankException(String message) {
        super(message);
    }

    public CnpjNullOrBlankException(String message, Throwable cause) {
        super(message, cause);
    }

    public CnpjNullOrBlankException(Throwable cause) {
        super(cause);
    }
}


