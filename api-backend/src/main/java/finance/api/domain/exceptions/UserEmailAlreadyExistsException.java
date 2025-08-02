package finance.api.domain.exceptions;

public class UserEmailAlreadyExistsException extends IllegalArgumentException{
    public UserEmailAlreadyExistsException(){
        super("User with this email already exists");
    }

}
