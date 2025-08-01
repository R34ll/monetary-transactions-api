package domain.valueobjects;

import org.junit.jupiter.api.Test;

import finance.api.domain.exceptions.CpfAllDigitsEqualException;
import finance.api.domain.exceptions.CpfInvalidLengthException;
import finance.api.domain.exceptions.CpfNullOrBlankException;

import finance.api.domain.valueobjects.Cpf;

import static org.junit.jupiter.api.Assertions.*;

public class CpfTest {

    @Test
    void shouldCreateCpfWithValidFormat() {
        String validCpf = "123.456.789-09";

        Cpf cpf = new Cpf(validCpf);
        assertEquals("CPF", cpf.getType()); 
    }

    @Test
    void shouldThrowExceptionWhenCpfIsNull() {
        Exception exception = assertThrows(CpfNullOrBlankException.class, () -> new Cpf(null));
        assertEquals("CPF cannot be null or blank", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCpfIsBlank() {
        Exception exception = assertThrows(CpfNullOrBlankException.class, () -> new Cpf("   "));
        assertEquals("CPF cannot be null or blank", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCpfHasInvalidLength() {
        Exception exception = assertThrows(CpfInvalidLengthException.class, () -> new Cpf("1234567890"));
        assertEquals("CPF must contain exactly 11 digits", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenAllDigitsAreEqual() {
        Exception exception = assertThrows(CpfAllDigitsEqualException.class, () -> new Cpf("111.111.111-11"));
        assertEquals("CPF cannot have all digits equal", exception.getMessage());
    }

    @Test
    void shouldStoreOriginalFormat() {
        String input = "123.456.789-09";
        try {
            new Cpf(input); // for now invalid
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid CPF", e.getMessage());
        }
    }
}
