public class Email {
    private final String email;
    
    public Email(String email){
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    public String getValue() {
        return email;
    }
}
