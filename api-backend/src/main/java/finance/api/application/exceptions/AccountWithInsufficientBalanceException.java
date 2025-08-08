package finance.api.application.exceptions;


public class AccountWithInsufficientBalanceException extends IllegalArgumentException{
    public AccountWithInsufficientBalanceException(){
        super("Account balance is insufficient to complete this transaction.");
    }
}

