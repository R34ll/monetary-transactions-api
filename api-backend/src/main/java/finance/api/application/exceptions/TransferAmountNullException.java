package finance.api.application.exceptions;

public class TransferAmountNullException extends IllegalArgumentException{
    public TransferAmountNullException(){
        super("Transfer amount cannot be null.");
    }
}