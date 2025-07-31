import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @Test
    void validEmailShouldBeAccepted() {
        Email email = new Email("user@example.com");
        assertEquals("user@example.com", email.getValue());
    }

    @Test
    void emailCannotBeNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Email(null);
        });
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void emailMustContainAtSymbol() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Email("userexample.com");
        });
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void emailCannotContainSpaces() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Email("user @example.com");
        });
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void emailWithValidSpecialCharacters() {
        Email email = new Email("user.name+tag@example.co.uk");
        assertEquals("user.name+tag@example.co.uk", email.getValue());
    }

    @Test
    void emailWithInvalidCharacters() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Email("user!@example.com");
        });
        assertEquals("Invalid email format", exception.getMessage());
    }
}
