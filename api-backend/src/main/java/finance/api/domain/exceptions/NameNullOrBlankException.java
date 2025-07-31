package finance.api.domain.exceptions;


public class NameNullOrBlankException extends IllegalArgumentException {
    public NameNullOrBlankException() {
        super("Name cannot be null or blank.");
    }
}