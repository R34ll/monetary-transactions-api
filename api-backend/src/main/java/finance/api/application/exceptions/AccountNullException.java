package finance.api.application.exceptions;


public class AccountNullException extends IllegalArgumentException{
    public AccountNullException(){
        super("Account cannot be null.");
    }
}