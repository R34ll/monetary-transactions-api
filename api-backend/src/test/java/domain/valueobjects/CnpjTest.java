import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CnpjTest {

    @Test
    void shouldAcceptValidCnpj() {
        // Exemplo de CNPJ válido
        String validCnpj = "45.723.174/0001-10"; // Substitua por um válido real se necessário
        assertDoesNotThrow(() -> new Cnpj(validCnpj));
    }

    @Test
    void shouldThrowWhenCnpjIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Cnpj(null));
    }

    @Test
    void shouldThrowWhenCnpjIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Cnpj("  "));
    }

    @Test
    void shouldThrowWhenCnpjHasLessThan14Digits() {
        assertThrows(IllegalArgumentException.class, () -> new Cnpj("123456789"));
    }

    @Test
    void shouldThrowWhenCnpjHasAllSameDigits() {
        assertThrows(IllegalArgumentException.class, () -> new Cnpj("11.111.111/1111-11"));
    }

    // @Test
    // void shouldThrowWhenCnpjIsInvalidByChecksum() {
    //     assertThrows(IllegalArgumentException.class, () -> new Cnpj("12.345.678/9012-34"));
    // }


}
