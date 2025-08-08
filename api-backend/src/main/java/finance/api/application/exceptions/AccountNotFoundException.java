package finance.api.application.exceptions;

public class AccountNotFoundException extends IllegalArgumentException{
    public AccountNotFoundException(){
        super("Account not found.");
    }
}