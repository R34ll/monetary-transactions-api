package finance.api.application.exceptions;

public class AccountAlreadyExistsException extends IllegalArgumentException {
    public AccountAlreadyExistsException(){
        super("Account already exists for user with provided id");
    }
    
}