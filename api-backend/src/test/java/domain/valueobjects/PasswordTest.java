import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import finance.api.domain.valueobjects.Password;
import finance.api.domain.exceptions.*;

class PasswordTest {

    @Test
    void validPasswordShouldBeAccepted() {
        String validPassword = "Str0ng!Pass";
        Password password = new Password(validPassword);
        assertEquals(validPassword, password.getValue());
    }

    @Test
    void nullPasswordShouldThrowException() {
        Exception exception = assertThrows(PasswordNullOrBlankException.class, () -> new Password(null));
        assertEquals("Password cannot be null or blank", exception.getMessage());
    }

    @Test
    void blankPasswordShouldThrowException() {
        Exception exception = assertThrows(PasswordNullOrBlankException.class, () -> new Password("   "));
        assertEquals("Password cannot be null or blank", exception.getMessage());
    }

    @Test
    void shortPasswordShouldThrowException() {
        Exception exception = assertThrows(PasswordTooShortException.class, () -> new Password("Ab1!"));
        assertEquals("Password must be at least 8 characters long", exception.getMessage());
    }

    @Test
    void passwordWithoutUppercaseShouldThrowException() {
        Exception exception = assertThrows(PasswordMissingUppercaseException.class, () -> new Password("lower1!pass"));
        assertEquals("Password must contain at least one uppercase letter", exception.getMessage());
    }

    @Test
    void passwordWithoutLowercaseShouldThrowException() {
        Exception exception = assertThrows(PasswordMissingLowercaseException.class, () -> new Password("UPPERCASE1!"));
        assertEquals("Password must contain at least one lowercase letter", exception.getMessage());
    }

    @Test
    void passwordWithoutDigitShouldThrowException() {
        Exception exception = assertThrows(PasswordMissingDigitException.class, () -> new Password("NoDigit!"));
        assertEquals("Password must contain at least one digit", exception.getMessage());
    }

    @Test
    void passwordWithoutSpecialCharacterShouldThrowException() {
        Exception exception = assertThrows(PasswordMissingSpecialCharacterException.class, () -> new Password("NoSpecial1"));
        assertEquals("Password must contain at least one special character", exception.getMessage());
    }
}
