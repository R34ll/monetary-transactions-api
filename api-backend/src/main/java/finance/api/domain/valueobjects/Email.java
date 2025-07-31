package finance.api.domain.valueobjects;


public class Email {
    private final String email;
    
    public Email(String email){
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email format");
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
