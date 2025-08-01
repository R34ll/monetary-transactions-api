import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import finance.api.domain.exceptions.EmailInvalidFormatException;
import finance.api.domain.valueobjects.Email;


public class EmailTest {

    @Test
    void validEmailShouldBeAccepted() {
        Email email = new Email("user@example.com");
        assertEquals("user@example.com", email.getValue());
    }

    @Test
    void emailCannotBeNull() {
        EmailInvalidFormatException exception = assertThrows(EmailInvalidFormatException.class, () -> {
            new Email(null);
        });
        assertEquals("The provided email format is invalid.", exception.getMessage());
    }

    @Test
    void emailMustContainAtSymbol() {
        EmailInvalidFormatException exception = assertThrows(EmailInvalidFormatException.class, () -> {
            new Email("userexample.com");
        });
        assertEquals("The provided email format is invalid.", exception.getMessage());
    }

    @Test
    void emailCannotContainSpaces() {
        EmailInvalidFormatException exception = assertThrows(EmailInvalidFormatException.class, () -> {
            new Email("user @example.com");
        });
        assertEquals("The provided email format is invalid.", exception.getMessage());
    }

    @Test
    void emailWithValidSpecialCharacters() {
        Email email = new Email("user.name+tag@example.co.uk");
        assertEquals("user.name+tag@example.co.uk", email.getValue());
    }

    @Test
    void emailWithInvalidCharacters() {
        IllegalArgumentException exception = assertThrows(EmailInvalidFormatException.class, () -> {
            new Email("user!@example.com");
        });
        assertEquals("The provided email format is invalid.", exception.getMessage());
    }
}
