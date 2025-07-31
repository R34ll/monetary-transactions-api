import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

import finance.api.domain.valueobjects.Money;



class MoneyTest {

    @Test
    void shouldCreateMoneyWithValidPositiveValue() {
        Money money = new Money(new BigDecimal("100.00"));
        assertEquals(new BigDecimal("100.00"), money.getValue());
    }

    @Test
    void shouldThrowExceptionWhenValueIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Money(null);
        });
        assertEquals("Money value cannot be null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenValueIsNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Money(new BigDecimal("-10"));
        });
        assertEquals("Money cannot be negative", exception.getMessage());
    }

    @Test
    void shouldReturnToStringAsValue() {
        Money money = new Money(new BigDecimal("42.50"));
        assertEquals("42.50", money.toString());
    }

    @Test
    void shouldAllowZeroValue() {
        Money money = new Money(BigDecimal.ZERO);
        assertEquals(BigDecimal.ZERO, money.getValue());
    }
}
