package finance.api.domain.exceptions;

public class NameTooLongException extends IllegalArgumentException {
    public NameTooLongException() {
        super("Name cannot be longer than 250 characters.");
    }
}
