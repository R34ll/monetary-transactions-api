package domain.valueobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import finance.api.domain.exceptions.*;
import finance.api.domain.valueobjects.Name;


public class NameTest{
    @Test
    void validNameShouldBeAccepted(){
        Name name = new Name("John Doe");
        assertEquals("John Doe", name.getValue());
    }

    @Test
    void nameCannotBeNull(){
        IllegalArgumentException exception = assertThrows(NameNullOrBlankException.class, () -> {
            new Name(null);
        });
        
        assertEquals("Name cannot be null or blank.", exception.getMessage());

    }

    @Test
    void nameCannotBeBlank() {
        IllegalArgumentException exception = assertThrows(NameNullOrBlankException.class, () -> {
            new Name("   ");
        });
        assertEquals("Name cannot be null or blank.", exception.getMessage());
    }

    @Test
    void nameCannotBeLongerThan250Characters() {
        String longName = "a".repeat(251);
        IllegalArgumentException exception = assertThrows(NameTooLongException.class, () -> {
            new Name(longName);
        });
        assertEquals("Name cannot be longer than 250 characters.", exception.getMessage());
    }

    @Test
    void nameCannotContainNumbers() {
        IllegalArgumentException exception = assertThrows(NameInvalidCharactersException.class, () -> {
            new Name("John Doe123");
        });
        assertEquals("Name must not contain numbers or special characters.", exception.getMessage());
    }

    @Test
    void nameCannotContainSpecialCharacters() {
        IllegalArgumentException exception = assertThrows(NameInvalidCharactersException.class, () -> {
            new Name("John@Doe!");
        });
        assertEquals("Name must not contain numbers or special characters.", exception.getMessage());
    }

    @Test
    void nameWithAccentedCharactersIsAccepted() {
        Name name = new Name("José Álvares");
        assertEquals("José Álvares", name.getValue());
    }

    @Test
    void nameIsTrimmed() {
        Name name = new Name("  John Doe  ");
        assertEquals("John Doe", name.getValue());
    }

}
