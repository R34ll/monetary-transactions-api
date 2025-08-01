package finance.api.domain.valueobjects;

import finance.api.domain.exceptions.EmailInvalidFormatException;

public class Email {
    private final String email;
    
    public Email(String email){
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new EmailInvalidFormatException();
        }
        this.email = email;
    }

    /**
     * Returns the email value.
     *
     * @return the email as a String
     */
    public String getValue() {
        return email;
    }
}
