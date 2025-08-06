package finance.api.domain.exceptions;

public class DocumentInvalidFormatException extends IllegalArgumentException{
    public DocumentInvalidFormatException(){
        super("The document format is invalid.");
    }
}

