package finance.api.domain.valueobjects;

import java.math.BigDecimal;

public final class Money implements Comparable<Money> {
    private final BigDecimal amount; 

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

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;         
        if (other == null || getClass() != other.getClass()) return false; 

        Money money = (Money) other;
        return this.compareTo(money) == 0;
    }

    @Override
    public int hashCode() {
        return amount.stripTrailingZeros().hashCode();
    }

    @Override
    public int compareTo(Money other){
        return this.amount.compareTo(other.getValue());
    }

    public Money subtract(Money other){
        return new Money(this.amount.subtract(other.getValue()));
    }

    public Money addition(Money other){
        return new Money(this.amount.add(other.getValue()));
    }

}
