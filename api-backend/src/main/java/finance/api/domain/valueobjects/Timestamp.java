package finance.api.domain.valueobjects;


public final class Timestamp{
    private final long value;

    public Timestamp(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("Timestamp cannot be negative");
        }
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}