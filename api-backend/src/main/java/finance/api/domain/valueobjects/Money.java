import java.math.BigDecimal;

public final class Money {
    private final BigDecimal amount; // #TODO: turn this into int

    public Money(BigDecimal value) {
        if (value == null) {
            throw new IllegalArgumentException("Money value cannot be null");
        }

        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.amount = value;
    }

    public BigDecimal getValue() {
        return amount;
    }

    @Override
    public String toString() {
        return amount.toString();
    }
}
