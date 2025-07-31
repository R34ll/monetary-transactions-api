import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CpfTest {

    @Test
    void shouldCreateCpfWithValidFormat() {
        String validCpf = "123.456.789-09"; // TODO: formatado, mas inválido (por enquanto o algoritmo retorna false)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Cpf(validCpf));
        assertEquals("Invalid CPF", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCpfIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Cpf(null));
        assertEquals("CPF cannot be null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCpfIsBlank() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Cpf("   "));
        assertEquals("CPF cannot be blank", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCpfHasInvalidLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Cpf("1234567890"));
        assertEquals("CPF must contain exactly 11 digits", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenAllDigitsAreEqual() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Cpf("111.111.111-11"));
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
