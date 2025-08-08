package finance.api.application.exceptions;


public class SameAccountTransferException extends IllegalArgumentException{
    public SameAccountTransferException(){
        super("Source and destination accounts must be different.");
    }
}