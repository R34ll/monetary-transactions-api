package finance.api.application.exceptions;

public class InvalidTransactionAmountException  extends IllegalArgumentException{
    public InvalidTransactionAmountException(){
        super("Transaction amount is invalid." );
    }
}