package finance.api.domain.exceptions;

public class NameInvalidCharactersException extends IllegalArgumentException {
    public NameInvalidCharactersException() {
        super("Name must not contain numbers or special characters.");
    }
}
