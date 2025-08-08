package finance.api.application.exceptions;


public class AccountWithNoActiveStatusException extends IllegalArgumentException{
    public AccountWithNoActiveStatusException(){
        super("The account status is inactive.");
    }
    
} 