package finance.api.domain.valueobjects;


public final class EntityId{ 
    private final String value;

    public EntityId(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Entity ID cannot be null or blank");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    };
}