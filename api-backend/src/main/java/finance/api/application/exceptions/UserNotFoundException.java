package finance.api.application.exceptions;

public class UserNotFoundException extends IllegalArgumentException{
    public UserNotFoundException(){
        super("No user exists with the provided ID");
    }
}
