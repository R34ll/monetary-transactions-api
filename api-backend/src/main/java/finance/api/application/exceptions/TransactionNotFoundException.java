package finance.api.application.exceptions;


public class TransactionNotFoundException extends IllegalArgumentException{
    public TransactionNotFoundException(){
        super("Transaction not found!");
    }
}

