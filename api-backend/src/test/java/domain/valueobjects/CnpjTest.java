import org.junit.jupiter.api.Test;


import finance.api.domain.valueobjects.Cnpj;
import finance.api.domain.exceptions.CnpjAllDigitsEqualException;
import finance.api.domain.exceptions.CnpjInvalidLengthException;
import finance.api.domain.exceptions.CnpjNullOrBlankException;

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
        assertThrows(CnpjNullOrBlankException.class, () -> new Cnpj(null));
    }

    @Test
    void shouldThrowWhenCnpjIsBlank() {
        assertThrows(CnpjNullOrBlankException.class, () -> new Cnpj("  "));
    }

    @Test
    void shouldThrowWhenCnpjHasLessThan14Digits() {
        assertThrows(CnpjInvalidLengthException.class, () -> new Cnpj("123456789"));
    }

    @Test
    void shouldThrowWhenCnpjHasAllSameDigits() {
        assertThrows(CnpjAllDigitsEqualException.class, () -> new Cnpj("11.111.111/1111-11"));
    }

    // @Test
    // void shouldThrowWhenCnpjIsInvalidByChecksum() {
    //     assertThrows(IllegalArgumentException.class, () -> new Cnpj("12.345.678/9012-34"));
    // }


}
