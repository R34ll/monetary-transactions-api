package finance.api.domain.exceptions;

public class UserDocumentAlreadyExistsException extends IllegalArgumentException{
    public UserDocumentAlreadyExistsException(){
        super("User with this document already exists");
    }
}
